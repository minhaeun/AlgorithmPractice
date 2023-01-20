package baekjoon.mathematics.boj1929;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1929_3 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/mathematics/boj1929/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for (int i = M; i <= N; i++) {
            int count = 0;
            int x = (int) Math.sqrt(i);
            for (int j = 1; j <= x; j++) {
                if (i % j == 0) count++;
            }
            if (count == 1 && i != 1)
                System.out.println(i);
        }
    }
}
