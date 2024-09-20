package baekjoon.boj17484;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17484_2 {
    public static int[] dr = {1, 1, 1};
    public static int[] dc = {-1, 0, 1};
    public static int N, M, map[][], min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj17484/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            dfs(0, i, map[0][i], -1);
        }
        System.out.println(min);

    }
    public static void dfs(int r, int c, int sum, int delta){
        if(r == N - 1){
            if(min > sum)   min = sum;
            return;
        }

        for(int d = 0; d < 3; d++){
            if(d == delta)  continue;
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M)  continue;
            int value = sum + map[nr][nc];
            if(value > min) continue;
            dfs(nr, nc, value, d);
        }




    }
}
