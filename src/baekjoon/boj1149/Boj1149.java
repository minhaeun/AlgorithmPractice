package baekjoon.boj1149;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1149 {
    static int N, cost[][], dp[][];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj1149/input.txt"));
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

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = cost[i][j] + Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[N][i]);
        }
        System.out.println(min);
    }
}
