package baekjoon.boj1524;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1524 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1524/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            br.readLine();
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int Smax = 0;
            int Bmax = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++){
                int S = Integer.parseInt(st.nextToken());
                if(Smax < S) Smax = S;
            }
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < M; i++){
                int B = Integer.parseInt(st.nextToken());
                if(Bmax < B)    Bmax = B;
            }
            if(Bmax > Smax)    sb.append("B\n");
            else sb.append("S\n");

        }
        System.out.println(sb);

    }
}
