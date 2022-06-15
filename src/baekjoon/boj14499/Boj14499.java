package baekjoon.boj14499;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14499 {
    static int N, M, x, y, K, arr[][];
    static int dice[];
    static int[] dr = {0, 0, -1, 1}; // 동, 서, 북, 남
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj14499/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dice = new int[6];  // 아래, 뒤, 우, 좌, 앞,  위

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            int nr = x + dr[dir - 1];
            int nc = y + dc[dir - 1];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

            if (dir == 1) {
                int tmp = dice[3];
                // 좌 = 아래
                dice[3] = dice[0];
                // 아래 = 우
                dice[0] = dice[2];
                // 우 = 위
                dice[2] = dice[5];
                // 위 = 좌
                dice[5] = tmp;

            } else if (dir == 2) {
                int tmp = dice[5];
                // 위 = 우
                dice[5] = dice[2];
                // 우 = 아래
                dice[2] = dice[0];
                // 아래 = 좌
                dice[0] = dice[3];
                // 좌 = 위
                dice[3] = tmp;

            } else if (dir == 3) {
                int tmp = dice[0];
                // 아래 = 앞
                dice[0] = dice[4];
                // 앞 = 위
                dice[4] = dice[5];
                // 위 = 뒤
                dice[5] = dice[1];
                // 뒤 = 아래
                dice[1] = tmp;

            } else {
                int tmp = dice[1];
                // 뒤 = 위
                dice[1] = dice[5];
                // 위 = 앞
                dice[5] = dice[4];
                // 앞 = 아래
                dice[4] = dice[0];
                // 아래 = 뒤
                dice[0] = tmp;
            }

            if (arr[nr][nc] == 0) {
                arr[nr][nc] = dice[0];
            } else {
                dice[0] = arr[nr][nc];
                arr[nr][nc] = 0;
            }
            sb.append(dice[5]).append("\n");

            x = nr;
            y = nc;
        }
        System.out.println(sb.toString());


    }


}
