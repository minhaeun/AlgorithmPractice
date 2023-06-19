package baekjoon.boj1022;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1022 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1022/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int[][] vortex = new int[r2-r1+1][c2-c1+1];
        int max = 0;
        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++){
                vortex[i-r1][j-c1] = calculate(i, j);
                max = Math.max(max, vortex[i-r1][j-c1]);
            }
        }

        StringBuilder formatter = new StringBuilder("%");
        formatter.append(String.valueOf(max).length());
        formatter.append("d ");

        for(int i=0; i<=r2-r1; i++){
            for(int j=0; j<=c2-c1; j++){
                System.out.printf(formatter.toString(), vortex[i][j]);
            }
            System.out.println();
        }
    }

    static int calculate(int row, int column){
        int border = Math.max(Math.abs(row),Math.abs(column));
        int min = (int) Math.pow(2*border-1,2)+1;

        if(row == border){
            return min + 7*border -1 + column;
        }

        if(column == -border){
            return min + 5*border -1 + row;
        }

        if(row == -border){
            return min + 3*border -1 - column;
        }

        return min + border -1 - row;
    }
}
