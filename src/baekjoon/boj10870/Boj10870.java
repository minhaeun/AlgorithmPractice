package baekjoon.boj10870;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj10870 {
    static int N;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj10870/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        System.out.println(fibo(N));

    }
    public static int fibo(int N){
        if(N <= 1)  return N;
        return  fibo(N - 1) + fibo(N - 2);

    }
}
