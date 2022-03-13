package baekjoon.greedy.boj1339;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1339 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/greedy/boj1339/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] alpha = new char[10];
        int[] weight = new int[10];

        Arrays.fill(alpha, '0');

        for(int i = 0; i < N; i++){
            String str = br.readLine();

            int w = 1;
            for(int j = str.length()-1; j >= 0; j--){
                char ch = str.charAt(j);
                for(int k = 0; k < 10; k++){
                    if(alpha[k] == ch){
                        weight[k] += w;
                        break;
                    }else if(alpha[k] == '0'){
                        alpha[k] = ch;
                        weight[k] = w;
                        break;
                    }
                }
                w*= 10;
            }
        }
        Arrays.sort(weight);

        int sum = 0;
        for(int i = 9; i >= 0; i--){
            sum += i * weight[i];
        }
        System.out.println(sum);

    }
}
