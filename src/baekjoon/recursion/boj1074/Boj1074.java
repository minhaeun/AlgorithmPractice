package baekjoon.recursion.boj1074;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1074 {
    static int N, r, c, count;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/recursion/boj1074/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);

        search(size, r, c);
        System.out.println(count);

    }

    public static void search(int size, int r, int c) {
        if (size == 1) return;
        if (r < size / 2 && c < size / 2) {       // 0
            search(size / 2, r, c);
        } else if (r < size / 2 && c >= size / 2) {     // 1
            count += size * size / 4;
            search(size / 2, r, c - size / 2);
        } else if (r >= size / 2 && c < size / 2) {     // 2
            count += size * size / 4 * 2;
            search(size / 2, r - size / 2, c);
        } else {                                        // 3
            count += size * size / 4 * 3;
            search(size / 2, r - size / 2, c - size / 2);
        }
    }
}
