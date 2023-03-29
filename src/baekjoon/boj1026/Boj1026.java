package baekjoon.boj1026;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj1026 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1026/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] arr2 = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr2);


        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += arr[i] * arr2[N - i - 1];
        }
        System.out.println(sum);

    }
}
