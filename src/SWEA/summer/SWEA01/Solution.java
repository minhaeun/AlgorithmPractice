package SWEA.summer.SWEA01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static int N, M, dist[][];
    public static final int INF = 100000;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/SWEA/summer/SWEA01/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dist = new int[N + 1][N + 1];

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    dist[i][j] = INF;
                }
            }

            while(M-- > 0){
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                dist[a][b] = c;
            }
            for(int k = 1; k <= N; k++){
                for(int i = 1; i <= N; i++){
                    for(int j = 1; j <= N; j++){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
            int min = INF;
            for(int i = 1; i <= N; i++){
                min = Math.min(dist[i][i], min);
            }
            if(min == INF)  min = -1;
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.print(sb);
    }
}
