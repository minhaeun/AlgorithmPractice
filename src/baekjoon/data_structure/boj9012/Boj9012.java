package baekjoon.data_structure.boj9012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9012 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj9012/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == ')'){
                    if(!stack.isEmpty()){
                        if(stack.peek() == '('){
                            stack.pop();
                        }else{
                            stack.push(str.charAt(j));
                        }
                    }else{
                        stack.push(str.charAt(j));
                    }
                }else{
                    stack.push(str.charAt(j));
                }
            }
            if(stack.isEmpty()) System.out.println("YES");
            else    System.out.println("NO");
        }
    }
}
