package baekjoon.boj1543;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1543 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1543/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String s2 = br.readLine();

        int size = s.length();
        int size2 = s2.length();

        s = s.replace(s2, "");
        System.out.println((size - s.length()) / size2);

    }
}
