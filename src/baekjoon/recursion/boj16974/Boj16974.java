package baekjoon.recursion.boj16974;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16974 {
    static int N;
    static long X;
    static long[] hamburger, patty;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/recursion/boj16974/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());

        hamburger = new long[N + 1];
        patty = new long[N + 1];

        hamburger[0] = 1;
        patty[0] = 1;

        for(int i = 1; i <= N; ++i){
            hamburger[i] = 1 + hamburger[i - 1] + 1 + hamburger[i - 1] + 1;
            patty[i] = patty[i - 1] + 1 + patty[i - 1];
        }
        System.out.println(recursion(N, X));

    }

    static long recursion(int n, long x){
        if(n == 0){
            if(x == 0)  return 0;
            else if(x == 1)  return 1;
        }

        if(x == 1)  return 0;
        else if(x <= 1 + hamburger[n-1])    return recursion(n-1, x-1);
        else if(x == 1 + hamburger[n-1] + 1)    return patty[n-1] + 1;
        else if(x <= 1 + hamburger[n-1] + 1 + hamburger[n-1])   return patty[n-1] + 1 + recursion(n-1, x - (1 + hamburger[n-1] + 1));
        else    return patty[n-1] + 1 + patty[n-1];
    }

}
