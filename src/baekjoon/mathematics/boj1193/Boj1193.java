package baekjoon.mathematics.boj1193;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1193 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/mathematics/boj1193/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int count = 1, sum = 0;

        while(true){
            if(X <= sum + count){
                if(count % 2 == 1){
                    System.out.println((count - (X - sum - 1)) + "/" + (X - sum));
                    break;
                }
                else{
                    System.out.println((X - sum) + "/" + (count - (X - sum - 1)));
                    break;
                }
            }
            else{
                sum += count;
                count++;
            }
        }



    }
}
