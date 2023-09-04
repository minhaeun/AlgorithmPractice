package baekjoon.boj16234;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16234 {
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static int N, L, R, map[][], ans, sum, count;
    public static boolean visited[][];
    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj16234/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean isMove = false;
        while(true){
            visited = new boolean[N][N];
            isMove = false;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(visited[i][j])   continue;
                    if(bfs(new Point(i, j)))    isMove = true;
                }
            }
            if(isMove)  ans++;
            else break;
        }
        System.out.println(ans);
    }
    public static boolean bfs(Point point){
        ArrayList<Point> group = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        group.add(point);
        visited[point.r][point.c] = true;

        sum = map[point.r][point.c]; count = 1;
        while(!queue.isEmpty()){
            Point now = queue.poll();
            int r = now.r;
            int c = now.c;

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])   continue;
                int diff = Math.abs(map[r][c] - map[nr][nc]);
                if(diff < L || diff > R)    continue;
                count++;
                sum += map[nr][nc];
                visited[nr][nc] = true;
                queue.offer(new Point(nr, nc));
                group.add(new Point(nr, nc));
            }
        }

        if(group.size() == 1)   return false;
        int value = sum / count;
        for(Point p : group){
            map[p.r][p.c] = value;
        }
        return true;
    }
}
