package baekjoon.boj4485;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj4485 {
    public static int N, map[][], tc;
    public static int[][] visited;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static class Point implements Comparable<Point>{
        int r, c, cost;
        public Point(int r, int c, int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
        @Override
        public int compareTo(Point point){
            return this.cost - point.cost;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj4485/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        tc = 1;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0)  break;
            map = new int[N][N];
            visited = new int[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < N; i++){
                Arrays.fill(visited[i], Integer.MAX_VALUE);
            }

            Queue<Point> queue = new PriorityQueue<>();
            queue.offer(new Point(0, 0, map[0][0]));
            visited[0][0] = map[0][0];

            while(!queue.isEmpty()){
                Point now = queue.poll();
                int r = now.r;
                int c = now.c;
                int cost = now.cost;
                if(r == N - 1 && c == N - 1)    break;
                for(int d = 0; d < 4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if(cost + map[nr][nc] >= visited[nr][nc])  continue;
                    visited[nr][nc] = cost + map[nr][nc];
                    queue.offer(new Point(nr, nc, visited[nr][nc]));
                }

            }
            sb.append("Problem ").append(tc++).append(": ").append(visited[N - 1][N - 1]).append("\n");
        }
        System.out.println(sb);

    }

}
