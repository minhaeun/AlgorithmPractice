package baekjoon.mathematics.boj11689;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj11689 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/mathematics/boj11689/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long result = n;
        for(long p = 2; p <= Math.sqrt(n); p++){
            if(n % p == 0){
                result -= result / p;
                while(n % p == 0){
                    n /= p;
                }
            }
        }
        if(n > 1){
            result -= result / n;
        }
        System.out.println(result);

    }
}
