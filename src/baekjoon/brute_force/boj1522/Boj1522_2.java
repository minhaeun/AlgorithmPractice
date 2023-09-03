package baekjoon.brute_force.boj1522;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1522_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj1522/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int countA = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a')    countA++;
        }


        int min = Integer.MAX_VALUE;
        for(int i = 0; i < str.length() + countA; i++) {
            int countB = 0;
            for (int j = 0; j < countA; j++) {
                int index = (i + j) % str.length();
                if (str.charAt(index) == 'b') countB++;
            }
            if (min > countB) min = countB;
        }

        System.out.println(min);

    }
}
