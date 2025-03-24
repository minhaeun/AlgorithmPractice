package baekjoon.boj10610;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj10610 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj10610/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] arr = br.readLine().toCharArray();
        Arrays.sort(arr);

        int len = arr.length;
        int sum = 0;
        for(int i = len - 1; i >= 0; i--) {
            sum += arr[i] - '0';
            sb.append(arr[i]);
        }

        if(sum % 3 != 0 || arr[0] != '0'){
            System.out.println(-1);
            return;
        }
        System.out.println(sb);

    }
}
