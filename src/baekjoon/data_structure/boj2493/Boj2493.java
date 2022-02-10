package baekjoon.data_structure.boj2493;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2493 {
    static int N;
    static Stack<int[]> stack;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/data_structure/boj2493/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty()){
                if(stack.peek()[1] < value)    stack.pop();
                else{
                    sb.append(stack.peek()[0]).append(" ");
                    break;
                }
            }

            if(stack.isEmpty()){
                sb.append(0).append(" ");
            }
            stack.add(new int[]{i + 1, value});
        }
        System.out.println(sb);
    }
}
