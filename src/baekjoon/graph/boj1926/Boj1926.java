package baekjoon.graph.boj1926;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1926 {
    public static int n, m, paint[][];
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc=  {0, 0, -1, 1};
    public static boolean visited[][];
    public static class Point{
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj1926/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paint = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++){
                paint[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Point> queue = new LinkedList<>();
        int count = 0;
        int size = 0;
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(paint[i][j] == 0 || visited[i][j])    continue;
                queue.offer(new Point(i, j));
                visited[i][j] = true;
                count++;
                size = 0;
                while(!queue.isEmpty()){
                    Point now = queue.poll();
                    int r = now.r;
                    int c = now.c;
                    size++;
                    for(int d = 0; d < 4; d++){
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if(nr < 0 || nr >= n || nc < 0 || nc >= m || paint[nr][nc] == 0 || visited[nr][nc])    continue;
                        visited[nr][nc] = true;
                        queue.offer(new Point(nr, nc));
                    }
                }
                max = Math.max(size, max);
            }
        }
        System.out.println(count);
        System.out.println(max);

    }
}
