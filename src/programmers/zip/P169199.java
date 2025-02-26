package programmers.zip;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P169199 {
    public static int R, C, visited[][];
    public static char[][] map;
    public static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    public static int[] dc = {0, 0, -1, 1};
    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static int solution(String[] board) {
        R = board.length;
        C = board[0].length();

        map = new char[R][C];
        visited = new int[R][C];
        for(int i = 0; i < R; i++){
            Arrays.fill(visited[i], -1);
        }

        Point start = null, end = null;
        for(int i = 0; i < R; i++){
            String str = board[i];
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R') start = new Point(i, j);
                if(map[i][j] == 'G') end = new Point(i, j);
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.r][start.c] = 0;

        while(!queue.isEmpty()){
            Point now = queue.poll();
            int r = now.r;
            int c = now.c;

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == 'D') continue;

                while(nr >= 0 && nr < R  && nc >= 0 && nc < C && map[nr][nc] != 'D'){
                    nr += dr[d];
                    nc += dc[d];
                }

                nr -= dr[d];
                nc -= dc[d];

                if(visited[nr][nc] != -1 && visited[nr][nc] <= visited[r][c] + 1) continue;
                visited[nr][nc] = visited[r][c] + 1;

                if(map[nr][nc] == 'G'){
                    Math.min(visited[nr][nc], visited[r][c] + 1);
                    continue;
                }
                queue.offer(new Point(nr, nc));
            }
        }

        return visited[end.r][end.c];
    }
    public static void main(String[] args) {

        String[] board1 = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        String[] board2 = {".D.R", "....", ".G..", "...D"};
        String[] board3 = {"........D..", "...........", "...........", "...........", "...........", "...........", "R.D........", "...D.......", ".D..D......", "..D..D.....", "...D..D....", "....D.....D", ".....D.D...", ".........G."};
        String[] board4 = {"..R", "...", "...", "..D", "DG."};

        System.out.println(solution(board1));
        System.out.println(solution(board2));
        System.out.println(solution(board3));
        System.out.println(solution(board4));

    }
}
