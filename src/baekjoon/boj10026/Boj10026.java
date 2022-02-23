package baekjoon.boj10026;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj10026 {
    static int N, count1, count2;
    static char[][] map;
    static boolean visit[][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj10026/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    bfs(i, j);
                    count1++;
                }
            }
        }
        sb.append(count1).append(" ");
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    bfs2(i, j);
                    count2++;
                }
            }
        }
        sb.append(count2);

        System.out.println(sb.toString());

    }

    public static void bfs(int i, int j) {
        char color = map[i][j];
        Queue<Point> queue = new LinkedList<>();

        visit[i][j] = true;
        queue.offer(new Point(i, j));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = point.r + dr[d];
                int nc = point.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visit[nr][nc]) continue;
                if (map[nr][nc] == color) {
                    queue.offer(new Point(nr, nc));
                    visit[nr][nc] = true;
                }

            }
        }
    }

    public static void bfs2(int i, int j) {
        char color = map[i][j];
        Queue<Point> queue = new LinkedList<>();

        visit[i][j] = true;
        queue.offer(new Point(i, j));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = point.r + dr[d];
                int nc = point.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visit[nr][nc]) continue;
                if (color == 'B') {
                    if (map[nr][nc] == 'B') {
                        queue.offer(new Point(nr, nc));
                        visit[nr][nc] = true;
                    }
                } else {
                    if (map[nr][nc] != 'B') {
                        queue.offer(new Point(nr, nc));
                        visit[nr][nc] = true;
                    }
                }


            }
        }
    }


}
