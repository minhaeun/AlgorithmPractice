package baekjoon.boj2133;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2133 {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        if (N % 2 != 0) {
            System.out.println(0);
            return;
        }
        int sum = 0;
        dp[0] = 1;
        dp[2] = 3;

        for (int i = 4; i < N + 1; i += 2) {
            sum += dp[i - 4] * 2;
            dp[i] = dp[i - 2] * 3 + sum;
        }

        System.out.println(dp[N]);
    }

}
