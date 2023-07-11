package baekjoon.boj1956;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1956 {
    public static int V, E, dist[][];
    public static final int INF = 100000000;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1956/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V + 1][V + 1];

        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                dist[i][j] = INF;
            }
        }
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], cost);
        }

        for(int k = 1; k <= V; k++){
            for(int i = 1; i <= V; i++){
                for(int j = 1; j <= V; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int min = INF;
        for(int i = 1; i <= V; i++){
            min = Math.min(dist[i][i], min);
        }
        if(min == INF)  min = -1;
        System.out.println(min);
    }
}
