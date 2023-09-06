package baekjoon.boj1863;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj1863 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1863/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = y;
        }
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= N; i++){
            while(!stack.isEmpty() && stack.peek() > arr[i]){
                answer++;
                stack.pop();
            }
            if(!stack.isEmpty() && stack.peek() == arr[i])  continue;
            stack.push(arr[i]);
        }
        System.out.println(answer);


    }
}
