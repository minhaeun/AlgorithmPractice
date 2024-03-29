package baekjoon.mathematics.boj10430;

import java.io.*;
import java.util.StringTokenizer;

public class Boj10430 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/mathematics/boj10430/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        sb.append((A+B)%C).append("\n").append(((A%C) + (B%C))%C).append("\n").append((A*B)%C).append("\n").append(((A%C) * (B%C))%C);
        System.out.println(sb);
    }
}
