package baekjoon.boj2885;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj2885 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2885/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int size = 1;
        int count = 0;
        int size2 = 0;

        while(size < K){
            size *= 2;
            size2 = size;
        }

        while(K > 0){
            if(K >= size)   K -=size;
            else{
                size /= 2;
                count++;
            }
        }
        System.out.println(size2 + " " + count);

    }
}
