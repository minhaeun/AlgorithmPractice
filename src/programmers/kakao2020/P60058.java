package programmers.kakao2020;

import java.util.Stack;

public class P60058 {
    public static String solution(String p) {
        if(p.isEmpty()) return p;
        return check(p);
    }

    public static String check(String str) {
        if(str.isEmpty()) return str;
        if(isCorrect(str)) return str;
        String u = "", v = "";
        int open = 0, close = 0;
        int len = str.length();
        int i = 0;
        for(; i < len; i++){
            char ch = str.charAt(i);
            if(ch == '(') open++;
            else close++;
            u += ch;
            if(open == close) break;
        }
        i++;
        for(; i < len; i++){
            char ch = str.charAt(i);
            v += ch;
        }
        if(isCorrect(u)) return u += check(v);
        String tmp = "(";
        tmp += check(v);
        tmp += ")";
        u = u.substring(1, u.length() - 1);
        len = u.length();
        for(int j = 0; j < len; j++){
            char ch = u.charAt(j);
            if(ch == '(') ch = ')';
            else ch = '(';
            tmp += ch;
        }
        return tmp;
    }
    public static boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();
        int len = str.length();
        for(int i = 0; i < len; i++){
            char ch = str.charAt(i);
            if(ch == '(') stack.push(ch);
            else {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        String p1 = "(()())()";
        String p2 = ")(";
        String p3 = "()))((()";

        System.out.println(solution(p1));
        System.out.println(solution(p2));
        System.out.println(solution(p3));
    }
}
