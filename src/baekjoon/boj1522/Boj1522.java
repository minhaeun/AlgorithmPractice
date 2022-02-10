package baekjoon.boj1522;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1522 {
    static char[] chars;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj1522/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        chars = br.readLine().toCharArray();

        int count = 0;
        for(char ch : chars){
            if(ch == 'b')   count++;
        }

        int min = 1001;
        for(int i = 0; i < chars.length  ; i++){
            int result = 0;
            for(int j = 0; j < count; j++){
                if(chars[(i + j) % chars.length] == 'a') result++;
            }

            min = Math.min(min, result);

        }
        System.out.println(min);
    }
}
