package baekjoon.boj1024;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1024 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1024/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long N = Long.valueOf(st.nextToken());
        long L = Long.valueOf(st.nextToken());
        boolean flag = true;

        while (L <= 100) {
            long start = N / L - (L - 1) / 2;
            if(start < 0)   break;

            if(N == (start * 2 + L - 1) * L / 2){
                for(long i = 0; i < L; i++){
                    sb.append(start + i).append(" ");
                }
                flag = false;
                break;
            }
            L += 1;

        }
        if(flag)    sb.append(-1);
        System.out.println(sb);




    }
}
