package baekjoon.boj11501;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj11501 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj11501/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] arr;

        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long max = 0, sum = 0;
            for(int i = N - 1; i >= 0; i--){
                if(max < arr[i]){
                    max = arr[i];
                }else{
                    sum += max - arr[i];
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }
}
