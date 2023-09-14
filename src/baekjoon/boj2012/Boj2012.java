package baekjoon.boj2012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2012 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2012/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int[] ranks = new int[N + 1];
        for(int i = 1; i < N + 1; i++){
            ranks[i] = arr[i - 1];
        }
        long total = 0;
        for(int i = 1; i < N + 1; i++){
            total += Math.abs(i - ranks[i]);
        }
        System.out.println(total);
    }
}
