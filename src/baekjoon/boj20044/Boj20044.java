package baekjoon.boj20044;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj20044 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj20044/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N * 2];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 2 *N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            int sum = arr[i] + arr[2 * N - (i + 1)];
            if(min > sum)   min = sum;
        }
        System.out.println(min);
    }
}
