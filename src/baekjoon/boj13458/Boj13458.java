package baekjoon.boj13458;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13458 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj13458/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[] A = new long[N];
        long[] sub = new long[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            A[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        for(int i = 0; i < N; i++){
            long tmp = A[i] - B;
            if(tmp > 0)
                sub[i] = (long) Math.ceil( tmp / (C * 1.0));
        }

        long ans = 0;
        for(long value : sub){
            ans += value;
        }
        System.out.println(ans + N);

    }
}
