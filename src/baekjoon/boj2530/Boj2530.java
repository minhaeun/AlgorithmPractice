package baekjoon.boj2530;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2530 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2530/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int D = Integer.parseInt(br.readLine());

        B += D / 60;
        C += D % 60;

        B += C / 60;
        C = C % 60;

        A += B / 60;
        B = B % 60;

        A = A % 24;

        System.out.println(A + " " + B + " " + C);

    }
}
