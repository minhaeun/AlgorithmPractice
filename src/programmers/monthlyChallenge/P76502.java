package programmers.monthlyChallenge;

import java.util.Stack;

public class P76502 {
    public static int len;
    public static int solution(String s) {
        int answer = 0;
        len = s.length();
        if(len % 2 != 0) return answer;

        for(int i = 0; i < len; i++){
            if(check(s, i)) answer++;
        }
        return answer;
    }
    public static boolean check(String s, int start){
        Stack<Character> stack = new Stack<>();

        for(int i = start; i < start + len; i++){
            int index = i % len;
            char ch = s.charAt(index);
            if(ch == '(' || ch == '{' || ch == '[') stack.add(ch);
            else{
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if((ch == ')' && top == '(') || (ch == '}' && top == '{') || (ch == ']' && top == '[')) continue;
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "[](){}";
        String s2 = "}]()[{";
        String s3 = "[)(]";
        String s4 = "}}}";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
    }
}
