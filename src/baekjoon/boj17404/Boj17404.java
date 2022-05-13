package baekjoon.boj17404;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17404 {
    static int N;
    static final int INF = 1000000000;
    static int[][] cost;
    static int[][] dp;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj17404/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost = new int[N + 1][3];
        dp = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                if (i == k) {
                    dp[1][i] = cost[1][i];
                } else {
                    dp[1][i] = INF;
                }
            }

            for (int i = 2; i <= N; i++) {
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = cost[i][j] + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
                }
            }
            for (int i = 0; i < 3; i++) {
                if (i != k) min = Math.min(min, dp[N][i]);
            }
        }

        System.out.println(min);


    }
}
