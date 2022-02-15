package baekjoon.recursion.boj3040;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj3040 {
    static int[] input, numbers;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/recursion/boj3040/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = new int[9];
        numbers = new int[7];
        for(int i = 0; i < 9; i++){
            input[i] = Integer.parseInt(br.readLine());
        }
        combination(0, 0);
    }

    public static void combination(int count, int start){

        if(count == 7){
            int total = 0;
            for(int i = 0; i < 7; i++){
                total += numbers[i];
            }
            if(total == 100){
                for(int i = 0; i < 7; i++){
                    System.out.println(numbers[i]);
                }
            }
            return;
        }
        for(int i = start; i < 9; i++){
            numbers[count] = input[i];
            combination(count + 1, i + 1);
        }
    }
}
