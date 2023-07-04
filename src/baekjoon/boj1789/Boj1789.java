package baekjoon.boj1789;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1789 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1789/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long sum = 0;
        if(N == 1 || N == 2){
            System.out.println(1);
            return;
        }
        for(int i = 0; i < N; i++){
            sum += i;
            if(sum > N){
                System.out.println(i-1);
                return;
            }else if(sum == N){
                System.out.println(i);
                return;
            }
        }

    }
}
