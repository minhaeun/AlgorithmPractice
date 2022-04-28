package baekjoon.boj5557;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj5557 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj5557/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        long[][] memo = new long[N + 1][21];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        memo[1][arr[1]]++;

        for (int i = 2; i < N; i++) {
            for (int j = 0; j <= 20; j++) {
                if (memo[i - 1][j] > 0) {
                    if (arr[i] + j <= 20) {
                        memo[i][arr[i] + j] += memo[i - 1][j];
                    }
                    if (j - arr[i] >= 0) {
                        memo[i][j - arr[i]] += memo[i - 1][j];
                    }
                }
            }
        }
        System.out.println(memo[N - 1][arr[N]]);


    }
}
