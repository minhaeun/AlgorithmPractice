package baekjoon.dp.boj15989;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj15989 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/dp/boj15989/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[][] arr = new int[10001][4];
        arr[1][1] = 1;
        arr[2][1] = 1;
        arr[2][2] = 1;
        arr[3][1] = 1;
        arr[3][2] = 1;
        arr[3][3] = 1;

        for(int i = 4; i < 10001; i++){
            arr[i][1] = arr[i-1][1];
            arr[i][2] = arr[i-2][1] + arr[i-2][2];
            arr[i][3] = arr[i-3][1] + arr[i-3][2] + arr[i-3][3];
        }

        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            int sum = arr[n][1] + arr[n][2] + arr[n][3];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }
}
