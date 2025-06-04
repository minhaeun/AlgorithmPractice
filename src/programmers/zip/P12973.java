package programmers.zip;

import java.util.Stack;

public class P12973 {
    public static int solution(String s){
        char[] arr = s.toCharArray();
        int len = arr.length;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < len; i++){
            char ch = arr[i];
            if(stack.isEmpty()) stack.push(ch);
            else{
                if(stack.peek() == ch) stack.pop();
                else stack.push(ch);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
    public static void main(String[] args) {
        String s1 = "baabaa";
        String s2 = "cdcd";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
    }
}
