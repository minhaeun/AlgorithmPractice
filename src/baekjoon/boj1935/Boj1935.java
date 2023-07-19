package baekjoon.boj1935;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1935 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1935/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        int len = str.length();

        for(int i = 0; i < len; i++){
            char ch = str.charAt(i);
            if('A' <= ch && ch <= 'Z'){
                double d = arr[ch - 'A'];
                stack.push(d);
            }else{
                double d1 = stack.pop();
                double d2 = stack.pop();
                double d3 = 0.0;
                switch (ch){
                    case '+' :
                        d3 = d2 + d1;
                        break;
                    case '-':
                        d3 = d2 - d1;
                        break;
                    case '*':
                        d3 = d2 * d1;
                        break;
                    case '/':
                        d3 = d2 / d1;
                        break;
                }
                stack.push(d3);
            }
        }
        System.out.printf("%.2f", stack.pop());

    }
}
