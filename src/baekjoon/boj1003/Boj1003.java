package baekjoon.boj1003;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1003 {
    public static int zero, one, zero_plus_one;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1003/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            sb.append(zero).append(" ").append(one).append("\n");
        }
        System.out.println(sb);
    }

    public static void fibonacci(int N){
        zero = 1;
        one = 0;
        zero_plus_one = 1;

        for(int i = 0; i < N; i++){
            zero = one;
            one = zero_plus_one;
            zero_plus_one = zero + one;
        }
    }
}
