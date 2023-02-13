package baekjoon.sort.boj1427;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Boj1427 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/sort/boj1427/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();

        Arrays.sort(str);

        for(int i = str.length - 1; i >= 0; i--){
            System.out.print(str[i]);
        }
    }
}
