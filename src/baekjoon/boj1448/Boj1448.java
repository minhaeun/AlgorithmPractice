package baekjoon.boj1448;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Boj1448 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1448/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        Arrays.sort(arr, Collections.reverseOrder());

        for(int i = 0; i < N - 2; i++){
            if(arr[i] < arr[i + 1] + arr[i + 2]){
                max = Math.max(max, arr[i] + arr[i + 1] + arr[i + 2]);
            }
        }

        if(max == 0)    max = -1;
        System.out.println(max);



    }
}
