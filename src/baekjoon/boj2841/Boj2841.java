package baekjoon.boj2841;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2841 {
    static int N, P, count = 0;
    static Stack<Integer>[] stack;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj2841/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        stack = new Stack[7];

        for(int i = 1; i <= 6; i++){
            stack[i] = new Stack<>();
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 누르기
            if(stack[x].isEmpty() || stack[x].peek() < y){
                // 이미 누르고 있는 경우
                if(!stack[x].isEmpty() && stack[x].peek() == y)     continue;
                // 새로운 프렛
                stack[x].add(y);
                count++;
                continue;
            }

            // 떼기
            while(!stack[x].isEmpty() && stack[x].peek() > y){
                stack[x].pop();
                count++;
            }

            if(!stack[x].isEmpty() && stack[x].peek() == y)     continue;
            stack[x].add(y);
            count++;

        }
        System.out.println(count);


    }
}
