package baekjoon.boj2292;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj2292 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2292/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 1;
        int range = 2;

        if(N == 1) System.out.println(1);
        else{
            while (range <= N) {
                range += 6 * count;
                count++;
            }
            System.out.println(count);
        }

    }
}
