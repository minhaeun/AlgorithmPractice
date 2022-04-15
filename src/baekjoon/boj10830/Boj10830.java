package baekjoon.boj10830;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10830 {
    static int N, A[][], result[][];
    static long B;
    static final int MOD = 1000;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj10830/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        A = new int[N][N];
        result = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
            result[i][i] = 1;
        }

        while(B > 0){
            if(B % 2 == 1){
                result = cal(result, A);
            }
            A = cal(A, A);
            B /= 2;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    public static int[][] cal(int[][] arr1, int[][] arr2){
        int[][] tmp = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    tmp[i][j] += arr1[i][k] * arr2[k][j];

                    tmp[i][j] %= MOD;
                }
            }
        }
        return tmp;
    }
}
