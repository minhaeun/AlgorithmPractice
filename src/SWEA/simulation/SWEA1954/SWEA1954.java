package SWEA.simulation.SWEA1954;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1954 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("SWEA/simulation/SWEA1954/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int[] dr = { 0, -1, 0, 1 }; // 우, 하, 좌, 상
        int[] dc = { 1, 0, -1, 0 };

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] grid = new int[N][N];
            int[][] check = new int[N][N];
            int r = 0, c = 0, nr, nc;
            int count = 1;
            OUTER : while (true) {
                for (int d = 0; d < dr.length; d++) {
                    while (true) {
                        nr = r + dr[d];
                        nc = c + dc[d];
                        if (nr >= N || nc >= N || nr < 0 || nc < 0 || check[nr][nc] == 1) {
                            break;
                        }
                        grid[r][c] = count++;
                        check[r][c] = 1;
                        r = nr;
                        c = nc;
                    }
                    if(count == N*N) {
                        grid[r][c] = count;
                        check[r][c] = 1;
                        break OUTER;
                    }
                }
            }
            sb = new StringBuilder();
            sb.append("#").append(test_case).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(grid[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }

    }
}
