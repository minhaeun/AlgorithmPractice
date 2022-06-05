package baekjoon.boj13777;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj13777 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj13777/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;

            int start = 1;
            int end = 50;

            while (true) {
                int mid = (start + end) / 2;
                System.out.print(mid + " ");
                if(mid == num) break;
                else if(mid > num){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            System.out.println();
        }
    }
}
