package baekjoon.brute_force.boj18290;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18290 {
    static int N, M, K, max, grid[][];
    static boolean visited[][];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj18290/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        grid = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 0);

        System.out.println(max);

    }

    public static void dfs(int i, int j, int count, int sum) {
        if (count == K) {
            max = Math.max(max, sum);
            return;
        }

        for (int r = i; r < N; r++) {
            for (int c = j; c < M; c++) {
                if (!visited[r][c] && check(r, c)){
                    visited[r][c] = true;
                    dfs(i, j, count + 1, sum + grid[r][c]);
                    visited[r][c] = false;
                }
            }
        }
    }

    public static boolean check(int r, int c) {
        boolean flag = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr >= 0 && nr < N && nc >= 0 && nc < M && visited[nr][nc])   flag = false;
        }

        return flag;
    }
}
