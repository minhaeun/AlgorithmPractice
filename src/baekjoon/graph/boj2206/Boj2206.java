package baekjoon.graph.boj2206;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2206 {
    static int N, M;
    static char[][] map;
    static boolean[][][] visit;
    static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};

    public static class Point {
        int r;
        int c;
        int count;
        boolean isbroken;

        public Point(int r, int c, int count, boolean isbroken) {
            this.r = r;
            this.c = c;
            this.count = count;
            this.isbroken = isbroken;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/graph/boj2206/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][];
        visit = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(bfs());

    }

    public static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1, false));
        visit[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.r == N - 1 && point.c == M - 1) return point.count;

            for (int d = 0; d < 4; d++) {
                int nr = point.r + dr[d];
                int nc = point.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if (map[nr][nc] == '0') {
                    if (point.isbroken && !visit[nr][nc][1]) {
                        queue.offer(new Point(nr, nc, point.count + 1, point.isbroken));
                        visit[nr][nc][1] = true;
                    } else if (!point.isbroken && !visit[nr][nc][0]) {
                        queue.offer(new Point(nr, nc, point.count + 1, point.isbroken));
                        visit[nr][nc][0] = true;
                    }
                } else if (map[nr][nc] == '1' && !point.isbroken && !visit[nr][nc][1]) {
                    queue.offer(new Point(nr, nc, point.count + 1, true));
                    visit[nr][nc][1] = true;
                }
            }
        }
        return -1;

    }
}
