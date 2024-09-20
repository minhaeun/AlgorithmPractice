package baekjoon.boj4485;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj4485_2 {
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static int N, arr[][];
    public static boolean visited[][];
    public static class Point{
        int r, c, cost;
        public Point(int r, int c, int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj4485/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int TC = 1;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            arr = new int[N][N];
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++){
                Arrays.fill(arr[i], 156251);
            }
            int[][] map = new int[N][N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            arr[0][0] = map[0][0];
            PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    return o1.cost - o2.cost;
                }
            });
            pq.offer(new Point(0, 0, map[0][0]));

            while(!pq.isEmpty()){
                Point now = pq.poll();
                int r = now.r;
                int c = now.c;
                if(r == N - 1 && c == N - 1) break;
                for(int d = 0; d < 4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
                    if(arr[nr][nc] < arr[r][c] + map[nr][nc]) continue;
                    arr[nr][nc] = arr[r][c] + map[nr][nc];
                    visited[nr][nc] = true;
                    pq.offer(new Point(nr, nc, arr[nr][nc]));
                }
            }
            sb.append("Problem ").append(TC).append(": ").append(arr[N - 1][N - 1]).append("\n");
            TC++;
        }
        System.out.println(sb);

    }
}
