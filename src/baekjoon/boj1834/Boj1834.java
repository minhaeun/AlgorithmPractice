package baekjoon.boj1834;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1834 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1834/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Integer.parseInt(br.readLine());
        long sum = 0;

        for(long i  = 1; i <= N -1; i++){
            sum += (N * i) + i;
        }
        System.out.println(sum);


    }
}
