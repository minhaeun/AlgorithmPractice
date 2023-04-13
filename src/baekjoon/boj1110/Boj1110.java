package baekjoon.boj1110;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1110 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1110/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int copy = N;

        do{
            N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
            cnt++;
        }while(copy != N);

        System.out.println(cnt);


    }
}
