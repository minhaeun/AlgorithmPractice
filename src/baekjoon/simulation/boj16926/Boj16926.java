package baekjoon.simulation.boj16926;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16926 {
    static int N;   // 배열 크기
    static int M;
    static int R;   // 회전 수
    static int[][] map;     //
    static int dr[] = {0, 1, 0, -1};     // 우, 하, 좌, 상
    static int dc[] = {1, 0, -1, 0};
    static int num;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/simulation/boj16926/input2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {     // 배열 입력
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long s = System.nanoTime();
        num = Math.min(N, M) / 2;       // 회전이 필요한 사각형의 수
        for (int i = 0; i < R; i++) {     // 회전 수 만큼 회전하기
            rotation();
        }
        System.out.println(System.nanoTime() - s);


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void rotation() {
        for (int n = 0; n < num; n++) {  // 회전해야하는 사각형만큼 반복문 돌리기
            int r = n;
            int c = n;
            int first = map[r][c];
            for (int d = 0; d < 4; d++) {
                while (true) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr < n || nc < n || nr >= N - n || nc >= M - n) break;     // 범위 확인
                    map[r][c] = map[nr][nc];       // 다음 값을 현재 값에 넣어주기
                    r = nr;
                    c = nc;
                }

            }
            map[n + 1][n] = first;   // 첫번째 값 다시 넣기
        }
    }
}
