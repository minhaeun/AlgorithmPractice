package programmers.pccp;

import java.util.*;

public class P250136 {
    public static int R, C, oil[];
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static boolean[][] visited;
    public static class Point{
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static int solution(int[][] land) {
        R = land.length;
        C = land[0].length;
        visited = new boolean[R][C];
        oil = new int[C];

        for(int i = 0; i < C; i++){
            for(int j = 0; j < R; j++){
                if(land[j][i] == 0 || visited[j][i]) continue;
                search(j, i, land);
            }
        }
        int answer = Arrays.stream(oil).max().getAsInt();
        return answer;
    }
    public static void search(int i, int j, int[][] land){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));
        visited[i][j] = true;
        int count = 1;
        Set<Integer> set = new HashSet<>();

        while(!queue.isEmpty()){
            Point now = queue.poll();
            set.add(now.c);
            int r = now.r;
            int c = now.c;
            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || land[nr][nc] == 0) continue;
                count += 1;
                visited[nr][nc] = true;
                queue.offer(new Point(nr, nc));
            }
        }
        for(int index : set) oil[index] += count;
    }

    public static void main(String[] args) {
        int[][] land1 = {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        int[][] land2 = {{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}};

        System.out.println(solution(land1));
        System.out.println(solution(land2));

    }
}
