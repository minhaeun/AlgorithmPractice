package baekjoon.boj2239;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Boj2239 {
    static int[][] grid;
    static int[][] check;
    static ArrayList<Point> arrayList;

    public static class Point{
        int r, c;
        Point (int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj2239/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        grid = new int[9][9];
        check = new int[9][9];
        arrayList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                grid[i][j] = str.charAt(j) - '0';
            }
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // 0이 아니면 다음 칸
                if (grid[r][c] != 0) continue;
                // 0인 좌표 리스트에 추가
                // arrayList.add(new Point(r, c));
                // 0이면 빈칸이니까 검사 시작
                checkArea(r, c);
                fillNum(r, c);
            }
        }

    }

    static void checkArea(int r, int c) {

        // 행 검사
        for (int i = 0; i < 9; i++) {
            if (grid[r][i] == 0) continue;
            check[r][c] |= 1 << (grid[r][i] - 1);
        }
        //System.out.println("행 끝 : " + check[r][c]);

        // 열 검사
        for (int i = 0; i < 9; i++) {
            if (grid[i][c] == 0) continue;
            check[r][c] |= 1 << (grid[i][c] - 1);
        }
        //System.out.println("열 끝 : " + check[r][c]);

        // 3x3 보드 검사
        int firstR = 0, firstC = 0;
        if (r != 0) firstR = r / 3 * 3;
        if (c != 0) firstC = c / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[firstR + i][firstC + j] == 0) continue;
                check[r][c] |= 1 << (grid[firstR + i][firstC + j] - 1);
            }
        }
        //System.out.println("보드 끝 : " + check[r][c]);
    }

    static void fillNum(int r, int c){
        for(int i = 0; i < 9; i++) {
            if ((grid[r][c] & (1 << i)) != (1 << i)) continue;
            check[r][c] |= 1 << i;
            grid[r][c] = i+1;
            return;
        }
    }

}
