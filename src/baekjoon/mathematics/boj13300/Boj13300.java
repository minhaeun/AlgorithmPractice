package baekjoon.mathematics.boj13300;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13300 {
    static int N;   // 참가 학생 수
    static int K;   // 최대 인원 수
    static int[][] info;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/mathematics/boj13300/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        info = new int[2][7];
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            info[r][c]++;
        }
        int count = 0;
        for(int i = 0; i < 2; i++){
            for(int j = 1; j < 7; j++){
                if(info[i][j] == 0) continue;
                count += info[i][j] / K;
                if(info[i][j] % K != 0)     count++;
            }
        }
        System.out.println(count);
    }
}
