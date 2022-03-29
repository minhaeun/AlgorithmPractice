package baekjoon.boj2562;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Boj2562 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj2562/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> num = new ArrayList<>();

        for(int i = 0; i < 9; i++){
            num.add(Integer.parseInt(br.readLine()));
        }

        int max = Collections.max(num);
        int index = num.indexOf(max);

        System.out.println(max);
        System.out.println(index + 1);



    }
}
