package baekjoon.graph.boj17086;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj17086 {
    public static int N, M, map[][];
    public static boolean visited[][];
    public static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    public static class Point{
        int r, c, dist;
        public Point(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj17086/input.txt"));
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
        int max = Integer.MIN_VALUE;
        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                if(map[r][c] == 1)  continue;
                visited = new boolean[N][M];
                max = Math.max(bfs(r, c), max);
            }
        }
        System.out.println(max);
    }
    public static int bfs(int i, int j){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j, 0));
        visited[i][j] = true;

        while(!queue.isEmpty()){
            Point now = queue.poll();
            int r = now.r;
            int c = now.c;
            int dist = now.dist;
            for(int d = 0; d < 8; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])  continue;
                if(map[nr][nc] == 1) return dist + 1;
                queue.offer(new Point(nr, nc, dist + 1));
                visited[nr][nc] = true;

            }
        }
        return 0;
    }
}
