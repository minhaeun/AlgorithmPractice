package baekjoon.boj2239;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj2239 {
    static int[][] grid;
    static int[][] check;
    static ArrayList<Point> arrayList;
    static int arrayLen;
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
        StringBuilder sb = new StringBuilder();

        grid = new int[9][9];
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
                 arrayList.add(new Point(r, c));
                // 0이면 빈칸이니까 검사 시작
            }
        }
        arrayLen = arrayList.size();
        dfs(0);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    static boolean dfs(int depth){
        if(depth == arrayLen){
            return true;
        }

        for(int i = 1; i <= 9; i++){
            Point point = arrayList.get(depth);
            if(available(i, point)){
                grid[point.r][point.c] = i;
                if(dfs(depth+1)) return true;
                grid[point.r][point.c] = 0;
            }
        }
        return false;
    }

    static boolean available(int num, Point point){
        int r = point.r;
        int c = point.c;

        // 세로 검사
        for (int i = 0; i < 9; i++) {
            if(grid[i][c] == num)   return false;
        }

        // 가로 검사
        for (int i = 0; i < 9; i++) {
            if (grid[r][i] == num) return false;
        }

        // 3x3 보드 검사
        int firstR = 0, firstC = 0;
        if (r != 0) firstR = r / 3 * 3;
        if (c != 0) firstC = c / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[firstR + i][firstC + j] == num)    return false;
            }
        }
        return true;
    }

}
