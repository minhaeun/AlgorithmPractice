package baekjoon.graph.boj16948;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16948 {
    public static int N, map[][];
    public static Point start, end;
    public static int[] dr = {-2, -2, 0, 0, 2, 2};
    public static int[] dc = {-1, 1, -2, 2, -1, 1};
    public static class Point{
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj16948/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        st = new StringTokenizer(br.readLine(), " ");
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        start = new Point(r1, c1);
        end = new Point(r2, c2);

        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        map[r1][c1]++;
        while(!queue.isEmpty()){
            Point now = queue.poll();
            int r = now.r;
            int c = now.c;
            for(int d = 0; d < 6; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 0)   continue;
                map[nr][nc] = map[r][c] + 1;
                queue.offer(new Point(nr, nc));
            }
        }
        if(map[r2][c2] == 0) System.out.println(-1);
        else System.out.println(map[r2][c2] - 1);


    }
}
