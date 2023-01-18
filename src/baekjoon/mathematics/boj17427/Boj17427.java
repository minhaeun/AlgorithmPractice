package baekjoon.mathematics.boj17427;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj17427 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("baekjoon/mathematics/boj17427/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        for(int i = 1; i <= N; i++){
            sum += i * (N/i);
        }
        System.out.println(sum);

    }
}
