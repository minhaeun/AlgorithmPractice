package baekjoon.boj3258;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj3258 {
    static int N, Z, M;
    static int[] obs;
    static ArrayList<Integer> arrayList;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj3258/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        Z = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        obs = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++)  obs[i] = Integer.parseInt(st.nextToken());

        if(Z == N)  Z = 0;

        OUTER : for(int K = 1; K < N; K++){
            arrayList = new ArrayList<>();
            for(int i = 0; i < N  ; i++){
                arrayList.add((1 + K * i) % N);
            }

            INNER : for(int value : arrayList){
                for(int ob : obs)  {
                    if(ob == value)     break INNER;
                }
                if(value == Z) {
                    System.out.println(K);
                    break OUTER;
                }
            }
        }

    }
}
