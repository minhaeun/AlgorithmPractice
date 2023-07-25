package baekjoon.boj1418;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1418 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1418/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 1; i <= N; i++){
            int now = i;
            int max = 0;

            for(int j = 2; j <= Math.sqrt(i);){
                if(now % j == 0){
                    now /= j;
                    max = j;
                }else j++;
            }
            if(now != 1)    max = now;
            if(max <=K) count++;
        }
        System.out.println(count);



    }
}
