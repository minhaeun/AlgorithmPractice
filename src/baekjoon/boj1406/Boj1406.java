package baekjoon.boj1406;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Boj1406 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1406/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String initialStr = br.readLine();
        int m = Integer.parseInt(br.readLine());

        for (int i=0;i<initialStr.length();i++) {
            leftStack.push(initialStr.charAt(i));
        }

        for (int i=0;i<m;i++) {
            String commandLine = br.readLine();
            char command = commandLine.charAt(0);

            switch (command) {
                case 'P':
                    leftStack.push(commandLine.charAt(2));
                    break;
                case 'B':
                    if (!leftStack.isEmpty()) leftStack.pop();
                    break;
                case 'L':
                    if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                    break;
                case 'D':
                    if (!rightStack.empty()) leftStack.push(rightStack.pop());
                    break;
                default: break;
            }
        }
        while(!leftStack.empty()) {
            rightStack.push(leftStack.pop());
        }
        while (!rightStack.empty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
    }
}
