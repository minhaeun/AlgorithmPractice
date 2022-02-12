package baekjoon.boj2669;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2669 {
    static boolean[][] grid;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj2669/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        grid = new boolean[101][101];

        for (int l = 0; l < 4; l++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            int er = Integer.parseInt(st.nextToken());
            int ec = Integer.parseInt(st.nextToken());

            for (int i = sr; i < er; i++) {
                for (int j = sc; j < ec; j++) {
                    grid[i][j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (grid[i][j]) count++;
            }
        }
        System.out.println(count);


    }
}
