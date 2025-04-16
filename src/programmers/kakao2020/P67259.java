package programmers.kakao2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P67259 {
    public static int N, map[][], visited[][][];
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static class Point{
        int r, c, d;
        public Point(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
    public static int solution(int[][] board) {
        N = board.length;
        visited = new int[N][N][4];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++)
                Arrays.fill(visited[i][j], 1000000001);
        }
        map = board.clone();

        Queue<Point> queue = new LinkedList<>();
        for(int d = 0; d < 4; d++){
            int nr = dr[d];
            int nc = dc[d];
            if(nr < 0 || nc < 0 || nr == N || nc == N || map[nr][nc] == 1) continue;
            visited[nr][nc][d] = 100;
            queue.offer(new Point(nr, nc, d));
        }

        while(!queue.isEmpty()){
            Point now = queue.poll();
            int r = now.r;
            int c = now.c;
            int bd = now.d;

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 1) continue;
                int value = 100;
                if(d != bd) value += 500;
                if(visited[nr][nc][d] > visited[r][c][bd] + value) {
                    visited[nr][nc][d] = visited[r][c][bd] + value;
                    queue.offer(new Point(nr, nc, d));
                }
            }
        }

        return Arrays.stream(visited[N - 1][N - 1]).min().getAsInt();
    }
    public static void main(String[] args) {
        int[][] board1 = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] board2 = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
        int[][] board3 = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
        int[][] board4 = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};

        System.out.println(solution(board1));
        System.out.println(solution(board2));
        System.out.println(solution(board3));
        System.out.println(solution(board4));
    }
}
