package baekjoon.greedy.boj11047;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11047_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/greedy/boj11047/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        int count = 0;

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N - 1; i >= 0; i--){
            if(K < A[i])   continue;
            if(K == 0)  break;
            count += K / A[i];
            K %= A[i];
        }

        System.out.println(count);

    }
}
