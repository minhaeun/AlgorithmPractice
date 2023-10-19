package baekjoon.boj2573;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2573 {
    public static int N, M, map[][];
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2573/input.txt"));
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

        int ans = 0;
        int count = 0;

        while((count = separate()) < 2){
            if(count == 0){
                ans = 0;
                break;
            }
            melt();
            ans++;
        }
        System.out.println(ans);

    }

    public static int separate(){
        boolean visited[][] = new boolean[N][M];

        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    dfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void dfs(int r, int c, boolean visited[][]){
        visited[r][c] = true;
        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0)   continue;
            dfs(nr, nc, visited);
        }
    }

    public static void melt(){
        Queue<Point> queue = new LinkedList<>();
        boolean visited[][] = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0)  continue;
                queue.offer(new Point(i, j));
                visited[i][j] = true;
            }
        }

        while(!queue.isEmpty()){
            Point now = queue.poll();
            int sea = 0;
            int r = now.r;
            int c = now.c;
            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] != 0)   continue;
                sea++;
            }

            if(map[r][c] - sea < 0) map[r][c] = 0;
            else map[r][c] -= sea;

        }


    }
}
