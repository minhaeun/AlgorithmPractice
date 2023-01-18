package baekjoon.boj17425;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj17425 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj17425/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        long[] G = new long[1000000];

        for(int i = 1; i <= 1000; i++){
            for(int j = 1; i * j <= 1000000; j++){
                if(i <= j) G[i * j - 1] += i;
                if(i < j) G[i * j - 1] += j;
            }
        }
        for(int i = 1; i < 1000000; i++){
            G[i] += G[i - 1];
        }

        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            sb.append(G[N-1]).append("\n");
        }
        System.out.print(sb);
    }
}
