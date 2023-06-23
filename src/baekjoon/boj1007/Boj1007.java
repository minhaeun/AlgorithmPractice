package baekjoon.boj1007;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1007 {
    static double result;
    static boolean[] isChecked;
    static int[][] P;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1007/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            result = Double.MAX_VALUE;
            isChecked = new boolean[N];
            P = new int[N][2];
            for (int j = 0; j < N; j++) {
                String[] temp = br.readLine().split(" ");
                P[j][0] = Integer.parseInt(temp[0]);
                P[j][1] = Integer.parseInt(temp[1]);
            }
            combination(0, N / 2);
            System.out.println(result);
        }
    }
    public static void combination(int index, int count){
        if (count == 0) result = Math.min(result, getVector());
        else{
            for (int i = index; i < P.length; i++) {
                isChecked[i] = true;
                combination(i + 1, count - 1);
                isChecked[i] = false;
            }
        }
    }
    public static double getVector() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < P.length; i++) {
            if (isChecked[i]) {
                x += P[i][0];
                y += P[i][1];
            } else {
                x -= P[i][0];
                y -= P[i][1];
            }
        }
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}