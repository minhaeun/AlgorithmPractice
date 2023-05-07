package baekjoon.boj2753;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj2753 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2753/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int y = Integer.parseInt(br.readLine());

        if(y % 4 == 0){
            if(y % 400 == 0) System.out.println("1");
            else if(y % 100 == 0) System.out.println("0");
            else System.out.println("1");
        }
        else System.out.println("0");


    }
}
