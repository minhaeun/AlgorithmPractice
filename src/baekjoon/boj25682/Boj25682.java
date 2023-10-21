package baekjoon.boj25682;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj25682 {
    public static int N, M, K;
    public static char[][] board;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj25682/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new char[N][];

        for(int i = 0; i < N; i++){
            board[i] = br.readLine().toCharArray();
        }
        System.out.println(Math.min(minimal('B'), minimal('W')));
    }

    public static int minimal(char color){
        int min = Integer.MAX_VALUE;
        int value;
        int[][] sum = new int[N + 1][M + 1];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if((i + j) % 2 == 0)    value = board[i][j] != color ? 1: 0;
                else    value = board[i][j] == color ? 1 : 0;
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + value;
            }
        }
        for(int i = 1; i <= N - K + 1; i++){
            for(int j = 1; j <= M - K + 1; j++){
                min = Math.min(min, sum[i + K - 1][j + K - 1] - sum[i + K - 1][j - 1] - sum[i - 1][j + K - 1] + sum[i - 1][j - 1]);
            }
        }
        return min;
    }
}
