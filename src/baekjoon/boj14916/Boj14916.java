package baekjoon.boj14916;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj14916 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj14916/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[2] = 1;
        dp[4] = 2;
        dp[5] = 1;

        for(int i = 6; i < n + 1; i++){
            dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
        }
        int result = dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
        System.out.println(result);
    }
}
