package baekjoon.boj2504;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj2504 {
    static char[] chars;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj2504/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        chars = br.readLine().toCharArray();
        stack = new Stack<>();

        int value = 1, ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(chars[i]);
                value *= 2;
            } else if (chars[i] == '[') {
                stack.push(chars[i]);
                value *= 3;
            } else if (chars[i] == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    ans = 0;
                    break;
                }
                if (chars[i - 1] == '(') {
                    ans += value;
                }
                stack.pop();
                value /= 2;

            } else {
                if (stack.isEmpty() || stack.peek() != '['){
                    ans = 0;
                    break;
                }
                if (chars[i - 1] == '[') {
                    ans += value;
                }
                stack.pop();
                value /= 3;

            }

            System.out.println(ans);
        }
        if(!stack.isEmpty()) System.out.println(0);
        else    System.out.println(ans);

    }

}
