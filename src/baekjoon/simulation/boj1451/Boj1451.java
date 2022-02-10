package baekjoon.simulation.boj1451;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1451 {
    static int N, M;
    static int [][] rec;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/simulation/boj1451/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        rec = new int[N][M];

        for(int i = 0; i < N; i++){
            char[] row = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                rec[i][j] = row[j] - '0';
            }
        }
        long max = Integer.MIN_VALUE;
        long s1, s2, s3;

        // 세3
        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                s1 = getSum(0, 0, N, i + 1);
                s2 = getSum(0, i + 1, N, j + 1);
                s3 = getSum(0, j + 1, N, M);
                max = Math.max(max, s1 * s2 * s3);
            }
        }
        // 가3
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                s1 = getSum(0, 0, i + 1, M);
                s2 = getSum(i + 1, 0, j + 1, M);
                s3 = getSum(j + 1, 0, N, M);
                max = Math.max(max, s1 * s2 * s3);
            }
        }
        // 왼-세1, 오-가2
        for (int i = 0; i < M - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                s1 = getSum(0, 0, N, i + 1);
                s2 = getSum(0, i + 1, j + 1, M);
                s3 = getSum(j + 1, i + 1, N, M);
                max = Math.max(max, s1 * s2 * s3);
            }
        }
        // 왼-가2 오-세1
        for (int i = 0; i < M - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                s1 = getSum(0, 0, j + 1, i + 1);
                s2 = getSum(j + 1, 0, N, i + 1);
                s3 = getSum(0, i + 1, N, M);
                max = Math.max(max, s1 * s2 * s3);
            }
        }
        //위-가1 아-세2
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                s1 = getSum(0, 0, i + 1, M);
                s2 = getSum(i + 1, 0, N, j + 1);
                s3 = getSum(i + 1, j + 1, N, M);
                max = Math.max(max, s1 * s2 * s3);
            }
        }
        // 위-세2 아-가1
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                s1 = getSum(0, 0, i + 1, j + 1);
                s2 = getSum(0, j + 1, i + 1, M);
                s3 = getSum(i + 1, 0, N, M);
                max = Math.max(max, s1 * s2 * s3);
            }
        }

        System.out.println(max);
    }

    public static long getSum(int sr, int sc, int er, int ec){
        long sum = 0;
        for(int i = sr; i < er; i++){
            for(int j = sc; j < ec; j++){
                sum += rec[i][j];
            }
        }
        return sum;
    }

}
