package baekjoon.graph.boj7562;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7562 {
    public static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj7562/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            int l = Integer.parseInt(br.readLine());
            int[][] visited = new int[l][l];
            st = new StringTokenizer(br.readLine(), " ");
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine(), " ");
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            Queue<Point> queue = new LinkedList<>();
            queue.offer(start);
            int count = 0;
            visited[start.r][start.c] = 1;
            while(!queue.isEmpty()){
                Point now = queue.poll();
                int r = now.r;
                int c = now.c;
                 if(r == end.r && c == end.c){
                    count = visited[r][c];
                    break;
                }
                for(int d = 0; d < 8; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nr >= l || nc < 0 || nc >= l || visited[nr][nc] != 0)   continue;
                    visited[nr][nc] = visited[r][c] + 1;
                    queue.offer(new Point(nr, nc));
                }
            }
            sb.append(count - 1).append("\n");
        }
        System.out.println(sb);
    }
}
