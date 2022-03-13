package baekjoon.boj17406;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17406 {
    static int N, M, K;
    static int[][] map;
    static Point[] points;
    static int min = Integer.MAX_VALUE;
    static int[] dr = {1, 0, -1, 0};    // 하, 우, 상, 좌
    static int[] dc = {0, 1, 0, -1};
    static int[] rdr = {0, 1, 0, -1};   // 우, 하, 좌, 상
    static int[] rdc = {1, 0, -1, 0};

    public static class Point {
        int r, c, s;

        Point(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj17406/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());   // 배열 세로 크기 (3 <= N <= 50)
        M = Integer.parseInt(st.nextToken());   // 배열 가로 크기 (3 <= M <= 50)
        K = Integer.parseInt(st.nextToken());   // 회전 횟수 (1 <= K <= 6)

        map = new int[N][M];    // 초기 2차원 배열
        points = new Point[K];  // 배열 돌리기 시작 point 배열

        // 입력 시작
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());   // 회전 시 중간 값 r
            int c = Integer.parseInt(st.nextToken());   // 회전 시 중간 값 c
            int s = Integer.parseInt(st.nextToken());   // 회전 시 delta

            points[i] = new Point(r, c, s); // 시작지점 저장 배열
        }

        perm(0, 0);
        System.out.println(min);

    }

    public static void perm(int cnt, int flag) {
        if (cnt == K) {   // 배열 완성되었으므로 최솟값 찾기
            for(int i = 0; i < N; i++){
                int sum = 0;
                for(int j = 0; j < M; j++){
                    sum += map[i][j];
                }
                min = Math.min(sum, min);
            }

            return;
        }

        for (int i = 0; i < K; i++) {
            if ((flag & 1 << i) != 0) continue;

            rotate(points[i].r, points[i].c, points[i].s, true);
            perm(cnt + 1, flag | 1 << i);
            rotate(points[i].r, points[i].c, points[i].s, false);

        }
    }


    public static void rotate(int rr, int cc, int s, boolean isClock) {
        for (int i = 1; i <= s; i++) {
            int r = rr - i - 1; // 배열 회전 시 제일 왼쪽 위 값
            int c = cc - i - 1;
            int tmp = map[r][c]; // tmp에 저장해두고 배열 돌리기
            for (int d = 0; d < 4; d++) {
                for (int j = 1; j <= 2 * i; j++) {  // 한 방향 당 가야하는 횟수
                    if (d == 3 && j == 2 * i) break;    // 왼쪽 위칸에 왔을 때
                    int nr,nc;
                    if(isClock){
                        nr = r + dr[d];
                        nc = c + dc[d];
                    }else{
                        nr = r + rdr[d];
                        nc = c + rdc[d];
                    }

                    map[r][c] = map[nr][nc];
                    r = nr;
                    c = nc;
                }
            }
            map[r][c] = tmp;    // 처음 tmp 값 할당

        }
    }

}
