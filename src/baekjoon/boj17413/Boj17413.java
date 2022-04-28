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
            if(str.charAt(i) == '<'){   // '<'이면 문자열 모두 pop하고 sb 추가
                while(!stack.isEmpty()) sb.append(stack.pop());
                while(str.charAt(i) != '>') sb.append(str.charAt(i++)); // '>' 만날때까지 문자열 그대로 더하기
                sb.append('>');
            } else if(str.charAt(i) == ' '){    //  빈칸일 경우 문자열 모두 pop하고 sb에 추가
                while(!stack.isEmpty()) sb.append(stack.pop());
                sb.append(' ');
            }else{  // 일반 문자들은 모두 stack에 넣기
                stack.push(str.charAt(i));
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop()); // stack에 남아있는 모든 문자열 pop
        System.out.println(sb.toString());
    }
}
