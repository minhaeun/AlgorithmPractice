package baekjoon.greedy.boj1946;

import java.io.*;
import java.util.StringTokenizer;

public class Boj1946 {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/greedy/boj1946/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a] = b;
            }

            int result = 1;
            int standard = arr[1];
            for(int i = 2; i <= N; i++){
                if(standard > arr[i]){
                    result++;
                    standard = arr[i];
                }
            }
            sb.append(result).append("\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}
