package baekjoon.boj10799;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj10799 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj10799/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();

        Stack<String> stack = new Stack<>();
        int count = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '(')    stack.push(String.valueOf(ch[i]));
            else if(ch[i] == ')'){
                if(ch[i - 1] == '('){
                    stack.pop();
                    count += stack.size();
                }else{
                    stack.pop();
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
