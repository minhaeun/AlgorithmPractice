package baekjoon.boj2748;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2748 {
    public static long[] arr;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2748/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new long[n + 1];
        Arrays.fill(arr, -1);
        arr[0] = 0;
        arr[1] = 1;
        System.out.println(fib(n));
    }
    public static long fib(int n){
        if(arr[n] == -1)    arr[n] = fib(n - 1) + fib(n - 2);
        return arr[n];
    }
}
