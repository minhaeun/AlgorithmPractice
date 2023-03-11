package baekjoon.boj1436;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1436 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1436/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int num = 666;
        int count = 1;

        while(count != N){
            num++;
            if(String.valueOf(num).contains("666")) count++;
        }
        System.out.println(num);

    }
}
