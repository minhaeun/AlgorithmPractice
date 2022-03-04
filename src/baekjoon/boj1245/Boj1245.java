package baekjoon.boj1245;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1245 {
    static int N;
    static int M;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dc = {0, 0, -1, 1, 1, -1, 1, -1};
    static boolean check = true;
    static boolean[][] visit;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1245/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        int count = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visit[i][j]){
                    check=true;
                    dfs(i, j);
                    if(check)   count++;
                }
            }
        }
        System.out.println(count);

    }
    public static void dfs(int r, int c){
        for(int d = 0; d < 8; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M)  continue;
            if(map[nr][nc] > map[r][c]) check = false;

            if(visit[nr][nc] || map[r][c] != map[nr][nc])   continue;
            visit[nr][nc] = true;
            dfs(nr, nc);

        }
    }
}
