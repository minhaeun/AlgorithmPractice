package baekjoon.simulation.boj16927;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16927 {
    public static int N, M, R, map[][];
    public static int[] dr = {0, 1, 0, -1};    // 우, 하, 좌, 상
    public static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/simulation/boj16927/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = Math.min(N, M) / 2;

        int tmpN = N;
        int tmpM = M;
        for (int n = 0; n < num; n++) {
            rotate(n, 2 * tmpN + 2 * tmpM - 4);
            tmpN -= 2;
            tmpM -= 2;
        }


        for (int[] row : map) {
            for (int value : row) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void rotate(int n, int len) {
        int rr = R % len;
        for (int i = 0; i < rr; i++) {
            int r = n;
            int c = n;
            int tmp = map[r][c];

            for (int d = 0; d < 4; d++) {
                while (true) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr < n || nr >= N - n || nc < n || nc >= M - n) break;
                    map[r][c] = map[nr][nc];
                    r = nr;
                    c = nc;
                }
            }
            map[n + 1][n] = tmp;
        }
    }

}
