package baekjoon.boj9935;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9935_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj9935/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String bomb = br.readLine();

        int strLen = str.length();
        int bombLen = bomb.length();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < strLen; i++){
            int count = 0;
            stack.push(str.charAt(i));

            if(stack.size() >= bombLen){
                for(int j = 0; j < bombLen; j++){
                    if(stack.get(stack.size() - bombLen + j) == bomb.charAt(j)) count++;
                }
                if(count == bombLen){
                    for(int k = 0; k < bombLen; k++) stack.pop();
                }
            }
        }

        if(stack.isEmpty()) System.out.println("FRULA");
        else{
            for(char ch : stack) sb.append(ch);
        }
        System.out.println(sb);

    }
}
