package baekjoon.brute_force.boj2563;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2563 {
    static int N;
    static boolean[][] paper;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/brute_force/boj2563/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        paper = new boolean[101][101];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for(int x = r; x < r + 10; x++){
                for(int y = c; y < c + 10; y++){
                    paper[x][y] = true;
                }
            }
        }

        int area = 0;
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                if(paper[i][j]) area++;
            }
        }
        System.out.println(area);


    }
}
