package baekjoon.brute_force.boj11047;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11047 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("baekjoon/brute_force/boj11047/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());   // 동전 종류
        int K = Integer.parseInt(st.nextToken());   // 만드려는 합

        int[] coin = new int[N];
        int count = 0;
        for(int i = 0; i < N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N - 1; i >= 0; i--){
            if(K >= coin[i]){
                count += K/coin[i];
                K %= coin[i];
            }
        }
        System.out.println(count);

    }
}
