package baekjoon.graph.boj1303;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1303 {
    public static char map[][];
    public static boolean visited[][];
    public static int N, M, W, B;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static class Point{
        int r, c;
        char color;
        Point(int r, int c, char color){
            this.r = r;
            this.c = c;
            this.color = color;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj1303/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j])   continue;
                bfs(new Point(i, j, map[i][j]));
            }
        }
        sb.append(W).append(" ").append(B);
        System.out.println(sb);

    }

    public static void bfs(Point start){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.r][start.c] = true;
        int count = 1;
        while (!queue.isEmpty()){
            Point now = queue.poll();
            int r = now.r;
            int c = now.c;
            int color = now.color;

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || color != map[nr][nc] || visited[nr][nc])  continue;
                queue.offer(new Point(nr, nc, map[nr][nc]));
                visited[nr][nc] = true;
                count++;
            }
        }
        if(start.color == 'W')  W += count * count;
        else B += count * count;
    }
}
