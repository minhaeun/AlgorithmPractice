package baekjoon.boj2609;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2609 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2609/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int max = 0;

        for(int i = 1; i <= num1 && i <= num2; i++){
            if(num1 % i == 0 && num2 % i == 0){
                max = i;
            }
        }

        int min = (num1 * num2) / max;

        System.out.println(max);
        System.out.println(min);

    }
}
