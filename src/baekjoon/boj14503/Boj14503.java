package baekjoon.boj14503;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14503 {
    public static int N, M, map[][], count;
    public static int[] dr = {-1, 0, 1, 0}; // 북, 동, 남, 서
    public static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj14503/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(count);
    }

    public static void dfs(int r, int c, int dir){
        if(map[r][c] == 1)  return;
        if(map[r][c] == 0){
            map[r][c] = 2;
            count++;
        }

        for(int d = 0; d < 4; d++){
            dir = (dir + 3) % 4;
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] > 0)  continue;
            dfs(nr, nc, dir);
            return;
        }

        dfs(r - dr[dir], c - dc[dir], dir);
    }


}
