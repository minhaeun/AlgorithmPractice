package baekjoon.graph.boj2206;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2206_2 {
    public static int N, M, min = Integer.MAX_VALUE, count[][];
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static class Point{
        int r, c, dis;
        boolean flag;
        public Point(int r, int c, int dis, boolean flag){
            this.r = r;
            this.c = c;
            this.dis = dis;
            this.flag = flag;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj2206/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }
        visited = new boolean[N][M];
        count = new int[N][M];
        for(int i = 0; i < N; i++){
            Arrays.fill(count[i], 1000002);
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 0, false));
        visited[0][0] = true;
        count[0][0] = 1;

        while(!queue.isEmpty()){
            Point now = queue.poll();
            int r = now.r;
            int c = now.c;

            if(r == N - 1 && c == M - 1){
                System.out.println(now.dis);
                return;
            }

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])   continue;
                if(count[nr][nc] < count[r][c] + 1)     continue;
                boolean flag = now.flag;
                if(map[nr][nc] == '1'){
                    if(now.flag)    continue;
                    flag = true;
                }
                visited[nr][nc] = true;
                count[nr][nc] = count[r][c] + 1;
                queue.offer(new Point(nr, nc, count[nr][nc], flag));
            }

        }
        System.out.println(-1);

    }


}
