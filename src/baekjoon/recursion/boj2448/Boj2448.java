package baekjoon.recursion.boj2448;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj2448 {
    static int N;
    static char[][] star;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/recursion/boj2448/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        star = new char[N][2 * N - 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                star[i][j] = ' ';
            }

        }

        print(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }

    public static void print(int r, int c, int n) {
        if (n == 3) {
            star[r][c] = '*';
            star[r + 1][c - 1] = star[r + 1][c + 1] = '*';
            star[r + 2][c - 2] = star[r + 2][c - 1] = star[r + 2][c] = star[r + 2][c + 1] = star[r + 2][c + 2] = '*';
            return;
        }

        print(r, c, n / 2);
        print(r + n / 2, c - n / 2, n / 2);
        print(r + n / 2, c + n / 2, n / 2);
    }
}
