package baekjoon.boj1094;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1094 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1094/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i <= 6; i++){
            count += (X&1<<i) != 0 ? 1:0;
        }
        System.out.println(count);
    }
}
