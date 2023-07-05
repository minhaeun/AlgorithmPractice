package baekjoon.boj13301;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj13301 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj13301/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Long> result = new ArrayList<>();
        ArrayList<Long> fibo = new ArrayList<>();
        fibo.add((long)1);
        fibo.add((long)1);
        for(int i = 2; i < N; i++)  fibo.add(fibo.get(i - 2) + fibo.get(i - 1));
        result.add((long)4);
        for(int i = 1; i < N; i++)  result.add(result.get(i - 1) + 2 * fibo.get(i));
        System.out.println(result.get(N - 1));

    }
}
