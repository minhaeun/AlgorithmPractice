package baekjoon.graph.boj18404;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj18404 {
    public static int N, M, map[][];
    public static int[] dr = {-2, -2, -1, -1, 1, 1, 2, 2};
    public static int[] dc = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj18404/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        st = new StringTokenizer(br.readLine(), " ");
        int sr = Integer.parseInt(st.nextToken()) - 1;
        int sc = Integer.parseInt(st.nextToken()) - 1;

        bfs(sr, sc);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            sb.append(map[r][c] - 1).append(" ");
        }
        System.out.println(sb);

    }

    public static void bfs(int i, int j){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));
        map[i][j] = 1;

        while(!queue.isEmpty()){
            Point now = queue.poll();
            int r = now.r;
            int c = now.c;
            for(int d = 0; d < 8; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 0)    continue;
                map[nr][nc] = map[r][c] + 1;
                queue.offer(new Point(nr, nc));
            }
        }
    }
}
