package baekjoon.boj2346;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj2346 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2346/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        Deque<int[]> q = new ArrayDeque<>();

        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb.append("1 ");
        int in = arr[0];

        for(int i = 1; i < N; i++){
            q.offer(new int[] {(i + 1), arr[i]});
        }

        while(!q.isEmpty()){
            if(in > 0){
                for(int i = 1; i < in; i++){
                    q.offer(q.poll());
                }

                int[] next = q.poll();
                in = next[1];
                sb.append(next[0] + " ");
            }
            else{
                for(int i = 1; i < -in; i++){
                    q.addFirst(q.pollLast());
                }
                int[] next = q.pollLast();
                in = next[1];
                sb.append(next[0] + " ");
            }
        }
        System.out.println(sb);

    }
}
