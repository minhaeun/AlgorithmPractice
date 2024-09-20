package baekjoon.boj17484;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17484_3 {
    public static int N, M, map[][], min = Integer.MAX_VALUE;
    public static int dr = 1;
    public static int[] dc = {-1, 0, 1};
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
            dfs(i, map[0][i], 0, -1);
        }

        System.out.println(min);
    }
    public static void dfs(int start, int sum, int depth, int dir){
        if(depth == N - 1) {
            min = Math.min(sum, min);
            return;
        }

        for(int d = 0; d < 3; d++){
            if(dir == d) continue;
            int nr = depth + dr;
            int nc = start + dc[d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            int value = sum + map[nr][nc];
            if(value > min) continue;
            dfs(nc, value, nr, d);
        }
    }
}
