package baekjoon.boj2622;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj2622 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2622/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 1; i < N - i; i++){
            for(int j = i; j <= N - i - j; j++){
                if(i + j > N - i - j)   count++;
            }
        }

        System.out.println(count);
    }
}
