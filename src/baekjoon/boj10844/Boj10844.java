package baekjoon.boj10844;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj10844 {
    static int N;
    static int MOD = 1_000_000_000;
    static int[][] dp;
    static long sum;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj10844/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < N + 1; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
            for (int j = 1; j < 9; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % MOD;
            }
        }

        for (int i = 0; i < 10; i++) {
            //sum = (sum + dp[N][i]) % MOD;
            sum += dp[N][i];
            sum %= MOD;
            // sum += dp[N][i] % MOD; (x)
        }
        System.out.println(sum);
    }
}
