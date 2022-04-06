package baekjoon.boj10886;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj10886 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj10886/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += Integer.parseInt(br.readLine());
        }

        if(N - sum > sum){
            System.out.println("Junhee is not cute!");
        }else{
            System.out.println("Junhee is cute!");
        }

    }
}
