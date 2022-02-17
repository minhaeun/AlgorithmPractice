package baekjoon.recursion.boj1987;

import java.io.*;
import java.util.StringTokenizer;

public class Boj1987 {
    static int R, C;
    static char map[][];
    static int[] dr = {-1, 1, 0, 0};    // 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};
    static int max;
    static boolean[] chars;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/recursion/boj1987/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][];
        chars = new boolean[26];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int r = 0, c = 0;
        int count = 1;
        chars[map[r][c] - 65] = true;
        move(r, c, count);

        System.out.println(max);
    }

    public static void move(int r, int c, int count) {

        max = Math.max(max, count);

        for (int d = 0; d < 4; d++) {

            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if (chars[map[nr][nc] - 65])   continue;
            chars[map[nr][nc] - 65] = true;
            move(nr, nc, count + 1);
            chars[map[nr][nc] - 65] = false;

        }
    }
}
