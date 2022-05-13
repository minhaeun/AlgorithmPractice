package baekjoon.boj2580;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj2580 {
    static int[][] grid;
    static ArrayList<Point> arrayList;
    static int listLen;

    public static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj2580/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        grid = new int[9][9];
        arrayList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 0) {
                    arrayList.add(new Point(i, j));
                }
            }
        }

        listLen = arrayList.size();

        dfs(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static boolean dfs(int depth) {
        if (depth == listLen) {
            return true;
        }

        for (int i = 1; i < 10; i++) {
            Point cur = arrayList.get(depth);
            if (available(cur, i)) {
                grid[cur.r][cur.c] = i;
                if(dfs(depth + 1)) return true;
                grid[cur.r][cur.c] = 0;
            }

        }
        return false;
    }

    private static boolean available(Point cur, int num) {
        int r = cur.r;
        int c = cur.c;

        for (int i = 0; i < 9; i++) {
            if (grid[r][i] == num) return false;
            if (grid[i][c] == num) return false;
        }

        int sr = r / 3 * 3;
        int sc = c / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[sr + i][sc + j] == num) return false;
            }
        }
        return true;
    }


}
