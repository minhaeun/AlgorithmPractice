package baekjoon.boj2578;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2578 {
    static int[][] map;
    static boolean[][] bingo;
    static int r, c;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj2578/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5];
        bingo = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int x = 0, y = 0;
        OUTER:
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                find(num);
                bingo[r][c] = true;

                if (check() >= 3) {
                    x = i;
                    y = j;
                    break OUTER;
                }

            }
        }

        System.out.println(5 * x + y + 1);
    }

    static void find(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == num) {
                    r = i;
                    c = j;
                }
            }
        }
    }

    static int check() {
        // 가로
        int total = 0;
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == true) {
                    count++;
                }
            }
            if (count == 5) total++;
        }

        // 세로
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] == true) {
                    count++;
                }
            }
            if (count == 5) total++;
        }

        // 대각선1
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == true) {
                count++;
            }
        }
        if (count == 5) total++;

        // 대각선2
        count = 0;
        int j = 4;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][j] == true) {
                count++;
            }
            j--;
        }
        if (count == 5) total++;

        return total;
    }
}
