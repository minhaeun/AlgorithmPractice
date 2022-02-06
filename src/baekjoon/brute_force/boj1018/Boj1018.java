package baekjoon.brute_force.boj1018;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1018 {
    static char[][] map;
    static boolean[][] visit;
    static char[][] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj1018/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M  = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M];
        arr = new char[N][M];

        int[] dr = {1, -1, 0, 0}; // 상, 하, 좌, 우
        int[] dc = {0, 0, -1, 1};

        String[] input = new String[N];

        for(int i = 0; i < N; i++){
            input[i] = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = input[i].charAt(j);
            }
        }

        for(int i = 0; i <= N - 8; i++){
            for(int j = 0; j <= M - 8; j++){
                check(i, j);
            }
        }
        System.out.println(answer);
    }

    static void check(int x, int y){
        char value = map[x][y];
        int count = 0;
        for(int i = x; i < x + 8; i++){
            for(int j = y; j < y + 8; j++){
                if(map[i][j] != value){
                    count++;
                }
                if(value == 'W'){
                    value = 'B';
                }else{
                    value = 'W';
                }
            }
            if(value == 'W'){
                value = 'B';
            }else{
                value = 'W';
            }
        }
        answer = Math.min(answer, Math.min(count, 64 - count));
    }
}
