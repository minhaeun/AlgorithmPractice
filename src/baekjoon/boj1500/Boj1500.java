package baekjoon.boj1500;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1500 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1500/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int div = S / K;
        int mod = S % K;
        long max = 1;
        for(int i = 1; i <= K; i++){
            if(i <= mod)    max *= div + 1;
            else max *= div ;
        }
        System.out.println(max);
        
    }
}
