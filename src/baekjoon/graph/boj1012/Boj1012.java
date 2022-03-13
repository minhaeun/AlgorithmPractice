package baekjoon.graph.boj1012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1012 {
    static int M, N, K;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/graph/boj1012/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int count = 0;
            map = new int[N][M];
            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                map[r][c] = 1;
            }

            for(int i = 0; i < N; i++){
                for(int j= 0; j < M; j++){
                    if(map[i][j] != 0){
                        dfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }// end of testCase
        System.out.println(sb.toString());
    }

    public static void dfs(int r, int c){
        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M)  continue;

            if(map[nr][nc] == 0)    continue;

            map[nr][nc] = 0;
            dfs(nr, nc);
        }
    }
}
