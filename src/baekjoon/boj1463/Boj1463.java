package baekjoon.boj1463;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1463 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj1463/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;

        for(int i = 2; i <= N; i++){
            if(i % 3 == 0){
                if(dp[i] > 1 + dp[i/3]){
                    dp[i] = 1 + dp[i/3];
                }
            }if(i % 2 == 0){
                if(dp[i] > 1 + dp[i/2]){
                    dp[i] = 1 + dp[i/2];
                }
            }if(dp[i] > 1 + dp[i-1]){
                dp[i] = 1 + dp[i-1];
            }
        }
        System.out.println(dp[N]);

    }
}
