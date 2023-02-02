package baekjoon.brute_force.boj14500;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14500_2 {
    static int N, M, max, map[][];
    static boolean visited[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj14500/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                dfs(0, 0, i, j);
                bfs(i, j);
            }
        }

        System.out.println(max);
    }

    public static void dfs(int count, int value, int r, int c){
        if(count == 4){
            max = Math.max(value, max);
            return;
        }

        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])   continue;
            visited[nr][nc] = true;
            dfs(count + 1, value + map[nr][nc], nr, nc);
            visited[nr][nc] = false;
        }

    }

    public static void bfs(int r, int c){
        int value = map[r][c];
        int count = 0;
        int min = Integer.MAX_VALUE;

        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M)   continue;
            value += map[nr][nc];
            min = Math.min(min, map[nr][nc]);
            count++;
        }

        if(count == 3){
            max = Math.max(max, value);
        }
        if(count == 4){
            value -= min;
            max = Math.max(max, value);
        }

    }
}
