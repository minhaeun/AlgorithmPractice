package baekjoon.boj1932;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1932 {
    static int N, triangle[][], dp[][], result;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1932/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        triangle = new int[N+1][N+1];
        dp = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= i; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = triangle[1][1];

        for(int i = 1; i <= N-1; i++){
            for(int j = 1; j <= i; j++){
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j]);
            }
            for(int j = 1; j <= i+1; j++){
                dp[i+1][j] += triangle[i+1][j];
            }
        }

        for(int j = 1; j <= N; j++){
            result = Math.max(result, dp[N][j]);
        }
        System.out.println(result);


    }
}
