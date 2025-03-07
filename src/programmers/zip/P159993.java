package programmers.zip;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P159993 {
    public static char[][] map;
    public static int R, C;
    public static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    public static int[] dc = {0, 0, -1, 1};
    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static int solution(String[] maps) {

        R = maps.length;
        C = maps[0].length();
        Point start = null, exit = null, lever = null;
        map = new char[R][C];

        for(int i = 0 ; i < R; i++){
            for(int j = 0; j < C; j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') start = new Point(i, j);
                else if(map[i][j] == 'E') exit = new Point(i, j);
                else if(map[i][j] == 'L') lever = new Point(i, j);
            }
        }

        int first = bfs(start, lever);
        if(first == -1) return -1;

        int second = bfs(lever, exit);
        if(second == -1) return -1;

        return first + second;
    }

    public static int bfs(Point start, Point end){
        int[][] visited = new int[R][C];
        for(int i = 0; i < R; i++){
            Arrays.fill(visited[i], -1);
        }
        visited[start.r][start.c] = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            Point now = queue.poll();
            int r = now.r;
            int c = now.c;

            if(r == end.r && c == end.c) return visited[r][c];

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] != -1 || map[nr][nc] == 'X') continue;
                visited[nr][nc] = visited[r][c] + 1;
                queue.offer(new Point(nr, nc));
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String[] maps1 = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        String[] maps2 = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
        String[] maps3 = {"SXX","OOL","EXX"};

        System.out.println(solution(maps1));
        System.out.println(solution(maps2));
        System.out.println(solution(maps3));
    }
}
