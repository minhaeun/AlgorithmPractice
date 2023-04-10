package baekjoon.boj1075;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1075 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1075/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        N = (N / 100) * 100;

        while(N % F != 0)   N++;

        N %= 100;

        if (N < 10) System.out.println("0" + N);
        else System.out.println(N);
    }
}
