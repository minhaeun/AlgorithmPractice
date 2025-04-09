package baekjoon.boj16120;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj16120 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj16120/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String ppap = "PPAP";

        Stack<Character> stack = new Stack<>();
        int len = str.length();
        for(int i = 0; i < len; i++){
            stack.push(str.charAt(i));
            int size = stack.size();
            if(size >= 4){
                int count = 0;
                for(int j = 3; j >= 0; j--){
                    if(stack.get(size - 1 - j) == ppap.charAt(count)) count++;
                    else break;
                }
                if(count == 4){
                    for(int j = 0; j < 3; j++) stack.pop();
                }
            }
        }

        if(stack.size() == 1 && stack.peek() == 'P') System.out.println("PPAP");
        else System.out.println("NP");
    }
}
