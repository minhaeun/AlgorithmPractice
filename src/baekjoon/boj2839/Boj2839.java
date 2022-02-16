package baekjoon.boj2839;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2839 {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("./src/baekjoon/boj2839/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];

        Arrays.fill(dp, 5001);

        dp[3] = 1;
        if(N >= 5)  dp[5] = 1;
        for(int i = 6; i <= N; i++){
            dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
        }
        int value = dp[N];
        if(dp[N] >= 5001)   value = -1;
        System.out.println(value);
    }
}
