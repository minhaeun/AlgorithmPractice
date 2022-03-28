package baekjoon.boj2638;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2638 {
    public static class Point {
        int r, c;

        public Point(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
    }

    public static int N, M, cheeseCnt, answer;
    public static boolean[][] visited;
    public static int[][] grid;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj2638/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < M; ++j) {
                grid[i][j] = Integer.parseInt(st.nextToken());

                if (grid[i][j] == 1) {
                    cheeseCnt++;
                }
            }
        }

        while (cheeseCnt > 0) {
            visited = new boolean[N][M];
            bfs();
            answer++;
        }

        System.out.println(answer);

    }

    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};


    public static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int i = 0; i < 4; ++i) {
                int nr = point.r + dr[i];
                int nc = point.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }

                if (visited[nr][nc] && grid[nr][nc] == 1) {
                    grid[nr][nc] = 0;
                    cheeseCnt--;
                }

                if (!visited[nr][nc] && grid[nr][nc] == 0) {
                    q.offer(new Point(nr, nc));
                }

                visited[nr][nc] = true;
            }
        }
    }
}

