package baekjoon.boj2588;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj2588 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2588/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        sb.append(A * (B % 10)).append("\n").append(A * ((B % 100) / 10)).append("\n").append(A * (B / 100)).append("\n").append(A * B);
        System.out.println(sb);



    }
}
