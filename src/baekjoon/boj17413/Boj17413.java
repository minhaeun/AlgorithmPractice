package baekjoon.boj17413;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj17413 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj17413/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '<'){
                while(!stack.isEmpty()) sb.append(stack.pop());
                while(str.charAt(i) != '>') sb.append(str.charAt(i++));
                sb.append('>');
            } else if(str.charAt(i) == ' '){
                while(!stack.isEmpty()) sb.append(stack.pop());
                sb.append(' ');
            }else{
                stack.push(str.charAt(i));
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb.toString());
    }
}
