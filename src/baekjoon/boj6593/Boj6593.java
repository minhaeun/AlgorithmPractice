package baekjoon.boj6593;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj6593 {
    static int L, R, C, res;
    static char building[][][];
    static int[] dr = { -1, 0, 1, 0, 0, 0}, dc = { 0, -1, 0, 1, 0, 0}, df = { 0, 0, 0, 0, 1, -1 };
    static Info start;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj6593/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken()); // 빌딩의 층 수
            R = Integer.parseInt(st.nextToken()); // row
            C = Integer.parseInt(st.nextToken()); // column
            if (L + R + C == 0) break;

            building = new char[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    building[i][j] = br.readLine().toCharArray();
                    for (int k = 0; k < C; k++) {
                        // 시작점
                        if (building[i][j][k] == 'S') {
                            start = new Info(i, j, k);
                            building[i][j][k] = '#';
                        }
                    }
                }
                br.readLine();
            }

            res = process();
            if (res == -1) System.out.println("Trapped!");
            else System.out.println("Escaped in " + res + " minute(s).");
        }
    }

    private static int process() {

        int time = 0;
        Queue<Info> q = new LinkedList<>();
        q.add(start);

        int ff = 0, rr = 0, cc = 0, size = 0;;
        while (!q.isEmpty()) {

            ++time;
            size = q.size();
            while(size-- > 0) {
                Info now = q.poll();
                // 주변 or 다른 층으로 이동
                for (int d = 0; d < 6; d++) {
                    ff = now.f + df[d];
                    rr = now.r + dr[d];
                    cc = now.c + dc[d];

                    // 범위를 벗어날 경우
                    if (rr < 0 || cc < 0 || rr >= R || cc >= C || ff < 0 || ff >= L) continue;
                    // 이동할 수 없다면
                    if (building[ff][rr][cc] == '#') continue;

                    // 출구에 도달
                    if (building[ff][rr][cc] == 'E') return time;

                    building[ff][rr][cc] = '#';
                    q.add(new Info(ff, rr, cc));
                }
            }
        }

        return -1;
    }

    static class Info {
        int f, r, c;

        public Info(int f, int r, int c) {
            this.f = f;
            this.r = r;
            this.c = c;
        }

    }

}
