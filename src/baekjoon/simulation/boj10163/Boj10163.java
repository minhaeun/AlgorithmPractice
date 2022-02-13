package baekjoon.simulation.boj10163;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10163 {
    static int N;
    static int[][] grid;
    static int[] arr;
    static int num;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/simulation/boj10163/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        grid = new int[1001][1001];
        arr = new int[N + 1];

        int r = 0, c = 0, w = 0, h = 0;
        for(int n = 0; n < N; n++){
            num++;
            st = new StringTokenizer(br.readLine(), " ");
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for(int i = r; i < r + w; i++){
                for(int j = c; j < c + h; j++){
                    grid[i][j] = num;
                }
            }

        }

        int count = 0;

        for(int i = 0; i < 1001; i++){
            for(int j = 0; j < 1001; j++){
                arr[grid[i][j]]++;
            }
        }

        for(int i = 1; i <= N; i++){
            System.out.println(arr[i]);
        }



    }
}
