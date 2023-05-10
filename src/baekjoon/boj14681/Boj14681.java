package baekjoon.boj14681;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj14681 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj14681/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int Y = Integer.parseInt(br.readLine());

        if(X > 0){
            if(Y > 0) System.out.println(1);
            else System.out.println(4);
        }else{
            if(Y > 0) System.out.println(2);
            else System.out.println(3);
        }

    }
}
