package baekjoon.boj2559;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2559 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2559/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        for(int i = K; i <= N; i++){
            int sum = arr[i] - arr[i - K];
            if(max < sum)   max = sum;
        }
        System.out.println(max);


    }
}
