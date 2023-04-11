package baekjoon.boj1100;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1100 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1100/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;

        for(int i = 0; i < 8; i++){
           String s = br.readLine();
           for(int j = 0; j < 8; j++){
               if(s.charAt(j) == 'F' && (i + j) % 2 == 0)   cnt++;
           }
        }

        System.out.println(cnt);

    }
}
