package baekjoon.data_structure.boj2493;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2493_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj2493/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[N + 1];

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N + 1; i++){
            while(!stack.isEmpty()){
                if(arr[stack.peek()] < arr[i])  stack.pop();
                else{
                    sb.append(stack.peek()).append(" ");
                    break;
                }
            }
            if(stack.isEmpty()) sb.append(0).append(" ");
            stack.add(i);
        }
        System.out.println(sb);

    }
}
