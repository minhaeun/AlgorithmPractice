package baekjoon.data_structure.boj10986;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10986 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj10986/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] A = new long[N + 1];
        long[] S = new long[N + 1];
        long[] R = new long[M];
        long count = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            S[i] = S[i - 1] + A[i];
            long remainder = S[i] % M;
            if (remainder == 0) count++;
            R[(int)remainder]++;
        }

        for(int i = 0; i < M; i++){
            if(R[i] >= 2){
                count += (R[i] * (R[i] - 1)) / 2;
            }
        }

        System.out.println(count);
    }
}
