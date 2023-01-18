package baekjoon.mathematics.boj4375;

import java.io.*;

public class Boj4375 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/mathematics/boj4375/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            int exp = 1;
            long base = 1;
            int num = Integer.parseInt(input);

            while ((base = base % num) != 0) {
                base = base*10 + 1;
                exp++;
            }
            sb.append(exp).append("\n");
        }
        System.out.print(sb);
    }
}
