package SWEA.SWEA2805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2805 {
    static int N;
    static int[][] farm;
    static int sum;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/SWEA/SWEA2805/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(br.readLine());
            sum = 0;
            farm = new int[N][N];


            for (int i = 0; i < N; i++) {
                String row = br.readLine();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = row.charAt(j) - '0';
                }
            }
            int r = 0;
            for (; r <= N / 2; r++) {
                for (int c = 0; c <= r; c++) {
                    if (c == 0) sum += farm[r][N / 2];
                    else sum += farm[r][N / 2 + c] + farm[r][N / 2 - c];
                }
            }
            for (; r < N; r++) {
                for (int c = N - r - 1; c >= 0; c--) {
                    if (c == 0) sum += farm[r][N / 2];
                    else sum += farm[r][N / 2 + c] + farm[r][N / 2 - c];
                }
            }
            sb.append("#").append(tc).append(" ").append(sum);
            System.out.println(sb);
        }
    }
}
