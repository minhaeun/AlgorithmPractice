package boj1743;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1743 {
    public static int N, M, K, map[][];
    public static boolean visited[][];
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/boj1743/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1][M + 1];
        map = new int[N + 1][M + 1];
        Queue<Point> queue = new LinkedList<>();


        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }
        int max = 0, count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] != 1 || visited[i][j]) continue;
                queue.offer(new Point(i, j));
                visited[i][j] = true;
                count = 1;
                while (!queue.isEmpty()) {
                    Point now = queue.poll();
                    int r = now.r;
                    int c = now.c;

                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];


                        if (nr < 1 || nr >= N + 1 || nc < 1 || nc >= M + 1 || visited[nr][nc] || map[nr][nc] == 0) continue;
                        visited[nr][nc] = true;
                        queue.offer(new Point(nr, nc));
                        count++;
                    }
                }
                max = Math.max(max, count);

            }


        }
        System.out.println(max);

    }
}
