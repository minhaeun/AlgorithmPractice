package baekjoon.brute_force.boj2309;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2309_2 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj2309/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int arr[] = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        int diff = sum - 100;
        int a = 0, b = 0;
        OUTER : for(int i = 0; i < 9; i++){
            for(int j = i + 1; j < 9; j++){
                int tmp = arr[i] + arr[j];
                if(diff == tmp){
                    a = i;
                    b = j;
                    break OUTER;
                }
            }
        }

        for(int i = 0; i < 9; i++){
            if(i == a || i == b) continue;
            sb.append(arr[i]).append("\n");
        }

        System.out.print(sb);

    }
}
