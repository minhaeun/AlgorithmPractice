package baekjoon.brute_force.boj1051;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1051 {
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/brute_force/boj1051/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            String row = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = row.charAt(j) - '0';
            }
        }
        // (0,0)부터 탐색
        int max = Integer.MIN_VALUE;
        for(int r = 0; r < N; r++){
            for(int c = 0; c < M; c++){
                for(int k = 1; k < N; k++){
                    if(r + k == N || c + k == M)    break;
                    if(map[r][c] == map[r + k][c] && map[r][c] == map[r][c + k] && map[r][c] == map[r + k][c + k]){
                        max = Math.max(max, (k + 1) * (k + 1));
                    }
                }
            }
        }
        if(max == Integer.MIN_VALUE) System.out.println(1);
        else System.out.println(max);

    }
}
