package programmers.zip;

import java.util.*;

public class P154540 {
    public static ArrayList<Integer> list;
    public static int N, M, map[][];
    public static boolean[][] visited;
    public static int[] dr = {-1, 0, 1, 0};
    public static int[] dc = {0, -1, 0, 1};
    public static class Point{
        public int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static int[] solution(String[] maps) {
        list = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int value = 0;
                if(maps[i].charAt(j) == 'X') value = -1;
                else value = maps[i].charAt(j) - '0';
                map[i][j] = value;
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j] || map[i][j] == -1) continue;
                bfs(i, j);
            }
        }
        int size = list.size();
        if(size == 0) return new int[]{-1};
        Collections.sort(list);
        int[] answer = new int[size];
        for(int i = 0; i < size; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static void bfs(int i, int j){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(i, j));
        visited[i][j] = true;
        int sum = map[i][j];

        while(!queue.isEmpty()){
            Point now = queue.poll();
            int r =  now.r;
            int c = now.c;

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || map[nr][nc] == -1) continue;
                visited[nr][nc] = true;
                sum += map[nr][nc];
                queue.offer(new Point(nr, nc));
            }
        }
        list.add(sum);
    }

    public static void main(String[] args) {
        String[] maps1 = {"X591X","X1X5X","X231X", "1XXX1"};
        String[] maps2 = {"XXX","XXX","XXX"};

        System.out.println(Arrays.toString(solution(maps1)));
        System.out.println(Arrays.toString(solution(maps2)));
    }
}
