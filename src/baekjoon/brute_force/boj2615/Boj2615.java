package baekjoon.brute_force.boj2615;

import java.io.*;
import java.util.StringTokenizer;

public class Boj2615 {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj2615/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 19;
        int[][] grid = new int[n][n];

        int[] dr = {-1, 0, 1, 1};   //우상, 우, 우하,
        int[] dc = {1, 1, 1, 0};

        // input 처리
        for (int r = 0; r < n; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < n; c++) {
                grid[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        boolean flag = false;
        OUTER : for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) continue;  // 0이면 넘어가
                // 1이거나 2일 때만 확인
                for (int d = 0; d < dr.length; d++) { // 4방탐색(우상, 우, 상, 우하)

                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n || (grid[r][c] != grid[nr][nc])) continue;
                    count = 2;
                    while (true) {
                        int nnr = nr + dr[d];
                        int nnc = nc + dc[d];
                        if (nnr < 0 || nnr >= n || nnc < 0 || nnc >= n || (grid[r][c] != grid[nnr][nnc]))   // 범위 확인
                            break;
                        if (grid[nnr][nnc] == grid[r][c]) {
                            count++;
                            nr = nnr;
                            nc = nnc;
                        }
                    }
                    if (count == 5) {
                        int rr = r - dr[d];
                        int cc = c - dc[d];
                        if(rr >= 0 && rr < n && cc >= 0 && cc < n && (grid[r][c] == grid[rr][cc]))  continue;
                        flag = true;
                        System.out.println(grid[r][c]);
                        System.out.print((r + 1) + " " + (c + 1));
                        break OUTER;
                    }
                }
            }
        }
        if(!flag)
            System.out.print("0");


    }
}
