package baekjoon.boj22866;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj22866 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj22866/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] h = new int[N + 1];
        int[] count = new int[N + 1];
        int[] near = new int[N + 1];
        Stack<Integer> stack;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
            h[i] = Integer.parseInt(st.nextToken());
            near[i] = -100000;
        }

        stack = new Stack<>();
        for(int i = 1; i <= N; i++){
            while(!stack.isEmpty() && h[stack.peek()] <= h[i])  stack.pop();
            count[i] = stack.size();
            if(count[i] > 0)    near[i] = stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();
        for(int i = N; i > 0; i--){
            while(!stack.isEmpty() && h[stack.peek()] <= h[i])  stack.pop();
            int s = stack.size();
            count[i] += s;
            if(s > 0 && stack.peek() - i < i - near[i]) near[i] = stack.peek();
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(count[i]);
            if(count[i] > 0)    sb.append(" ").append(near[i]);
            sb.append("\n");
        }
        System.out.println(sb);






    }
}
