package baekjoon.boj2631;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj2631 {
    public static int N, arr[], dp[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2631/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new int[N + 1];

        for(int i = 1; i < N + 1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for(int i = 1; i < N + 1; i++){
            dp[i] = 1;
            for(int j = 1; j < i; j++){
                if(arr[i] > arr[j]){
                    if(dp[i] < dp[j] + 1)   dp[i] = dp[j] + 1;
                }
            }
            count = Math.max(count, dp[i]);
        }
        System.out.println(N - count);
    }
}
