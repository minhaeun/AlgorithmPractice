package baekjoon.boj2480;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2480 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2480/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int num3 = Integer.parseInt(st.nextToken());
        int money = 0;


        if(num1 == num2 && num2 == num3){
            money = 10000 + num1 * 1000;
        }else if(num1 != num2 && num2 != num3 && num3 != num1){
            int max = num1;
            max = Math.max(max, num2);
            max = Math.max(max, num3);
            money = max * 100;
        }else{
            if(num1 == num2){
                money = 1000 + num1 * 100;
            }else if(num2 == num3){
                money = 1000 + num2 * 100;
            }else{
                money = 1000 + num3 * 100;
            }
        }
        System.out.println(money);



    }
}
