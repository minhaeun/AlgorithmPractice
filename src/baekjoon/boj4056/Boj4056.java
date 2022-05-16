package baekjoon.boj4056;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Boj4056 {
    static int[][] grid;
    static ArrayList<Point> arrayList;
    static int arrayLen;

    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj4056/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            boolean duplicate = false;
            grid = new int[9][9];
            arrayList = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                String str = br.readLine();
                for (int j = 0; j < 9; j++) {
                    grid[i][j] = str.charAt(j) - '0';
                    if (grid[i][j] == 0) {
                        arrayList.add(new Point(i, j));
                    } else {
                        if (check(grid[i][j], new Point(i, j))) {
                            duplicate = true;
                        }
                    }
                }
            }

            arrayLen = arrayList.size();
            if (dfs(0) && !duplicate) {
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        sb.append(grid[i][j]);
                    }
                    sb.append("\n");
                }
            } else {
                sb.append("Could not complete this grid.\n");
            }
            sb.append("\n");

        }
        System.out.println(sb.toString().trim());


    }

    static boolean dfs(int depth) {
        if (depth == arrayLen) {
            return true;
        }
        for (int i = 1; i <= 9; i++) {
            Point cur = arrayList.get(depth);
            if (available(i, cur)) {
                grid[cur.r][cur.c] = i;
                if (dfs(depth + 1)) return true;
                grid[cur.r][cur.c] = 0;
            }
        }
        return false;
    }

    static boolean available(int num, Point point) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][point.c] == num) return false;
            if (grid[point.r][i] == num) return false;
        }

        int sr = point.r / 3 * 3;
        int sc = point.c / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[sr + i][sc + j] == num) return false;
            }
        }

        return true;
    }

    static boolean check(int num, Point point) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][point.c] == num && i != point.r) return true;
            if (grid[point.r][i] == num && i != point.c) return true;
        }

        int sr = point.r / 3 * 3;
        int sc = point.c / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sr + i == point.r && sc + j == point.c) continue;
                if (grid[sr + i][sc + j] == num) return true;
            }
        }

        return false;
    }
}
