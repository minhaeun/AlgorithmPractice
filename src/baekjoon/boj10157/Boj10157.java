package baekjoon.boj10157;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10157 {
    static int C, R, K;
    static int map[][];
    static boolean visit[][];
    static int dr[] = {0, 1, 0, -1}; // 우, 하, 좌, 상
    static int dc[] = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj10157/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        visit = new boolean[R][C];

        K = Integer.parseInt(br.readLine());

        if (K > C * R) {
            System.out.println("0");
            return;
        }

        int count = 1;
        int r = 0, c = 0;
        int d = 0;

        for (int k = 1; k <= R * C; k++) {
            visit[r][c] = true;
            if (k == K) {

                sb.append(r + 1).append(" ").append(c + 1);
                System.out.println(sb);
                return;
            }

            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C || visit[nr][nc]) {
                d = (d + 1) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            }

            r = nr;
            c = nc;

        }

    }
}
