package baekjoon.boj9935;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9935 {

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj9935/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String sentence = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();

        Stack<Character> stack = new Stack<>();

        OUTER : for(int i = 0; i < sentence.length(); i++){
            stack.push(sentence.charAt(i));

            if(stack.size() >= bombLen){
                for(int j = 0; j < bombLen; j++){
                    if(stack.get(stack.size() - bombLen + j) != bomb.charAt(j)) continue OUTER;
                }
                for(int j = 0; j < bombLen; j++)    stack.pop();

            }

        }
        for(char ch : stack){
            sb.append(ch);
        }
        if(stack.isEmpty()) System.out.println("FRULA");
        else System.out.println(sb);

    }

}
