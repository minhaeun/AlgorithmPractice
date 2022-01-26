package baekjoon.data_structure.boj1874;

import java.io.*;
import java.util.Stack;

public class Boj1874 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj1874/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] sequence = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            sequence[i] = Integer.parseInt(br.readLine());
        }

        int num = 1;

        for(int i = 0; i < n; i++){
            while(num <= sequence[i]){
                stack.push(num++);
                sb.append("+\n");
            }
            if(stack.peek() == sequence[i]){
                sb.append("-\n");
                stack.pop();
            }
            else{
                System.out.print("NO");
                return;
            }
        }
        System.out.print(sb);



    }
}


