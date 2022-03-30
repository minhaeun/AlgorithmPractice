package baekjoon.boj2636;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2636 {
    static int N, M;
    static int[][] grid;
    static boolean[][] visit;
    static int cheeseCount, time, count;
    static int[] dr = {-1, 1, 0, 0};  // 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};

    public static class Point{
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2636/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                if(grid[i][j] == 1){
                    cheeseCount++;
                }
            }
        }

        while(cheeseCount > 0){
            count = cheeseCount;
            bfs();
            time++;
        }
        System.out.println(time);
        System.out.println(count);
    }

    public static void bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        visit = new boolean[N][M];
        visit[0][0] = true;
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int r = point.r;
            int c = point.c;
            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || visit[nr][nc])  continue;

                if(grid[nr][nc] == 1){
                    cheeseCount--;
                    grid[nr][nc] = 0;
                }
                else if(grid[nr][nc] == 0){
                    queue.offer(new Point(nr, nc));
                }
                visit[nr][nc] = true;
            }

        }
    }
}
