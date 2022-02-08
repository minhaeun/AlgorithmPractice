package baekjoon.boj17213;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj17213 {
    static int N;
    static int M;
    static int i;
    //static int[] fruits;
    static int totalCount;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj17213/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        //fruits = new int[M - N];
        steal(0, 1);
        System.out.println(totalCount);
    }

    static void steal(int count, int start){
        if(count == M - N){
            totalCount++;
            //System.out.println((i++) + " : " + Arrays.toString(fruits));
            return;
        }
        for(int i = start; i <= N; i++){
            //fruits[count] = i;
            steal(count + 1, i);
        }
    }
}
