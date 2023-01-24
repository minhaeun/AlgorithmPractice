package baekjoon.mathematics.boj6588;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj6588 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/mathematics/boj6588/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[1000001];
        Arrays.fill(arr, true);
        arr[1] = false;

        for (int i = 2; i < 1000001; i++) {
            if (arr[i]) {
                for (int j = 2; i * j < 1000001; j++) {
                    arr[i * j] = false;
                }
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            boolean flag = true;

            for (int i = 3; i < n / 2 + 1; i += 2) {
                if (arr[i] && arr[n - i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
                    flag = false;
                    break;
                }
            }
            if (flag) sb.append("Goldbach's conjecture is wrong.\n");
        }
        System.out.print(sb);
    }
}
