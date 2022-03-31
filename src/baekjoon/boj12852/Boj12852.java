package baekjoon.boj12852;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj12852 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj12852/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        int[] seq = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[1] = 0;

        for(int i = 2; i <= N; i++){
            if(i % 3 == 0){
                if(dp[i] > 1 + dp[i/3]){
                    dp[i] = 1 + dp[i/3];
                    seq[i] = i / 3;
                }
            }if(i % 2 == 0){
                if(dp[i] > 1 + dp[i/2]){
                    dp[i] = 1 + dp[i/2];
                    seq[i] = i / 2;
                }
            }if(dp[i] > 1 + dp[i-1]){
                dp[i] = 1 + dp[i-1];
                seq[i] = i - 1;
            }
        }
        sb.append(dp[N]).append("\n");

        while(N > 0){
            sb.append(N).append(" ");
            N = seq[N];
        }

        System.out.println(sb.toString());



    }
}
