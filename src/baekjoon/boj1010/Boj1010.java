package baekjoon.boj1010;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1010 {
    public static int[][] dp = new int[30][30];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1010/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(comb(M, N)).append("\n");
        }
        System.out.println(sb);
    }

    public static int comb(int n, int r){
        if(dp[n][r] > 0)    return dp[n][r];

        if(n == r || r == 0)    return dp[n][r] = 1;

        return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }
}
