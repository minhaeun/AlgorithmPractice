package baekjoon.brute_force.boj14500;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14500 {
    static int N, M, ans = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj14500/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+2][M+2];
        visit = new boolean[N+2][M+2];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < M + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < M+1; j++) {
                dfs(i, j, 0, 0);

                int sum = map[i][j] + map[i+1][j] + map[i-1][j] + map[i][j+1] + map[i][j-1];
                //check(i, j, sum);

            }
        }

        System.out.println(ans);

    }

    public static void dfs(int i, int j, int count, int sum) {
        if (count == 4) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];

            if (nr <= 0 || nc <= 0 || nr > N || nc > M || visit[nr][nc]) continue;
            visit[nr][nc] = true;
            dfs(nr, nc, count + 1, sum + map[nr][nc]);
            visit[nr][nc] = false;
        }

    }

    public static void check(int i, int j, int sum) {

        for (int d = 0; d < 4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];

            ans = Math.max(ans, sum - map[nr][nc]);


        }

    }
}
