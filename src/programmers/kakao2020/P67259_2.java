package programmers.kakao2020;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class P67259_2 {
    public static int N, map[][], visited[][][];
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static class Point{
        int r, c, d, cost;
        public Point(int r, int c, int d, int cost) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.cost = cost;
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

        PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        for(int d = 0; d < 4; d++){
            visited[0][0][d] = 0;
        }
        pq.offer(new Point(0, 0, -1, 0));

        while(!pq.isEmpty()){
            Point now = pq.poll();
            int r = now.r;
            int c = now.c;
            int bd = now.d;
            int cost = now.cost;

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 1) continue;
                int newCost = cost + 100;
                if(bd != -1 && bd != d) newCost += 500;
                if(visited[nr][nc][d] > newCost){
                    visited[nr][nc][d] = newCost;
                    pq.offer(new Point(nr, nc, d, newCost));
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
