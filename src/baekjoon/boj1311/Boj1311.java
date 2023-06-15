package baekjoon.boj1311;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1311 {
    static final int INF = 99999999;
    static int N, dp[][], cost[][];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1311/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][1 << N];

        System.out.println(solve(0, 0));
    }

    public static int solve(int now, int flag){
        if(now == N)    return 0;
        if(dp[now][flag] != 0)  return dp[now][flag];

        int result = INF;
        for(int i = 0; i < N; i++){
            if((flag & (1 << i)) == 0){
                result = Math.min(result, cost[now][i] + solve(now + 1, flag | (1 << i)));
            }
        }
        dp[now][flag] = result;
        return dp[now][flag];
    }

}
