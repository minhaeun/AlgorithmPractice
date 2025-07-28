package programmers.dfsBfs;

import java.util.LinkedList;
import java.util.Queue;

public class P1844 {
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static int solution(int[][] maps) {
        int answer = -1;
        int N = maps.length;
        int M = maps[0].length;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0));
        maps[0][0] = 0;

        while(!queue.isEmpty()){
            Point point = queue.poll();
            int r = point.r;
            int c = point.c;
            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr == N - 1 && nc == M - 1){
                    answer = maps[r][c] + 2;
                    return answer;
                }
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || maps[nr][nc] == 0) continue;
                if(maps[nr][nc] <= maps[r][c] + 1 && maps[nr][nc] != 1) continue;

                queue.offer(new Point(nr, nc));
                maps[nr][nc] = maps[r][c] + 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] maps1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        System.out.println(solution(maps1));
    }
}
