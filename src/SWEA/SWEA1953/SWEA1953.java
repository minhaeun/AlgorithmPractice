package SWEA.SWEA1953;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1953 {
    static int N, M, R, C, L;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/SWEA/SWEA1953/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visit = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 경로 저장 큐
            Queue<Point> queue = new LinkedList<>();
            // 첫 멘홀 뚜껑 위치 장소 저장
            queue.add(new Point(R, C));
            visit[R][C] = true;
            int time = 0, count = 1;
            while (!queue.isEmpty()) {
                if (++time >= L) break;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Point cur = queue.poll();
                    int r = cur.r;
                    int c = cur.c;
                    int pipe = map[r][c];
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr < 0 || nr >= N || nc < 0 || nc >= M || visit[nr][nc] || map[nr][nc] == 0) continue;

                        int next = map[nr][nc];

                        switch (d) {
                            case 0:
                                if (pipe == 1 || pipe == 2 || pipe == 4 || pipe == 7) {
                                    if (next == 1 || next == 2 || next == 5 || next == 6) {
                                        visit[nr][nc] = true;
                                        queue.offer(new Point(nr, nc));
                                        count++;
                                    }
                                }
                                break;
                            case 1:
                                if (pipe == 1 || pipe == 2 || pipe == 5 || pipe == 6) {
                                    if (next == 1 || next == 2 || next == 4 || next == 7) {
                                        visit[nr][nc] = true;
                                        queue.offer(new Point(nr, nc));
                                        count++;
                                    }
                                }
                                break;
                            case 2:
                                if (pipe == 1 || pipe == 3 || pipe == 6 || pipe == 7) {
                                    if (next == 1 || next == 3 || next == 4 || next == 5) {
                                        visit[nr][nc] = true;
                                        queue.offer(new Point(nr, nc));
                                        count++;
                                    }
                                }
                                break;
                            case 3:
                                if (pipe == 1 || pipe == 3 || pipe == 4 || pipe == 5) {
                                    if (next == 1 || next == 3 || next == 6 || next == 7) {
                                        visit[nr][nc] = true;
                                        queue.offer(new Point(nr, nc));
                                        count++;
                                    }
                                }
                                break;
                        }
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }

}
