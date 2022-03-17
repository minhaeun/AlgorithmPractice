package baekjoon.mathematics.boj2558;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class boj2558 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("baekjoon/mathematics/boj2558/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        System.out.println(A + B);
    }
}
