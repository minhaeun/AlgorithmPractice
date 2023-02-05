package baekjoon.data_structure.boj11720;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj11720 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj11720/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] arr;

        arr = br.readLine().toCharArray();
        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += arr[i] - '0';
        }
        System.out.println(sum);
    }
}
