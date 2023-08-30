package baekjoon.boj14940;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14940 {
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static class Point{
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj14940/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Point start = null;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    visited[i][j] = true;
                    start = new Point(i, j);
                    map[i][j] = 0;
                }
            }
        }


        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            Point now = queue.poll();
            int r = now.r;
            int c = now.c;

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0 || visited[nr][nc])  continue;
                map[nr][nc] = map[r][c] + 1;
                queue.offer(new Point(nr, nc));
                visited[nr][nc] = true;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int value = map[i][j];
                if(map[i][j] > 0 && !visited[i][j]) value = -1;
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
