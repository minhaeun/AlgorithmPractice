package baekjoon.boj1076;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1076 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1076/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] color = {"black", "brown", "red", "orange", "yellow", "green",
                "blue", "violet", "grey", "white"};
        
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();

        long result = (Arrays.asList(color).indexOf(A) * 10) + Arrays.asList(color).indexOf(B);
        result *= Math.pow(10, Arrays.asList(color).indexOf(C));

        System.out.println(result);




    }
}
