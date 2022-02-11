package baekjoon.brute_force.boj2309;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2309 {
    static int N;
    static int[] height;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/brute_force/boj2309/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 9;
        height = new int[N];
        int sum = 0;

        for(int i = 0; i < N; i++){
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }

        Arrays.sort(height);
        int x1 = 0, x2 = 0;
        for(int i = 0; i < 8; i++){
            for(int j = i+1; j < 9; j++){
                if(sum - height[i] - height[j] == 100){
                   x1 = i;
                   x2 = j;
                }
            }
        }

        for(int i = 0; i < 9; i++){
            if(i != x1 && i != x2)
                System.out.println(height[i]);
        }



    }
}
