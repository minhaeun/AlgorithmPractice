package baekjoon.data_structure.boj17298;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17298 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj17298/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] ans = new int[N];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++){
            while(!stack.isEmpty() && A[stack.peek()] < A[i]){
                ans[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }

        for(int i = 0; i < N; i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);


    }
}
