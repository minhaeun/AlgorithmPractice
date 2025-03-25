package baekjoon.boj2212;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2212 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2212/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] diff = new int[N];
        for(int i = 0; i < N - 1; i++){
            diff[i] = arr[i + 1] -  arr[i];
        }

        Arrays.sort(diff);

        int sum = 0;
        for(int i = 0; i < N - K + 1; i++){
            sum += diff[i];
        }
        System.out.println(sum);

    }
}
