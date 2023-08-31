package baekjoon.dp.boj15988;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj15988 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/dp/boj15988/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        long[] arr = new long[1000001];

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for(int i = 4; i < 1000001; i++){
            arr[i] = (arr[i-1] + arr[i-2] + arr[i-3]) % 1000000009;
        }

        for(int t = 1; t <= T; t++){
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]).append("\n");
        }

        System.out.println(sb);

    }
}
