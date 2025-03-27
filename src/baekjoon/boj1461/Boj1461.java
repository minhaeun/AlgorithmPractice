package baekjoon.boj1461;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1461 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1461/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> nq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(st.nextToken());
            if(value > 0) pq.offer(value);
            else nq.offer(Math.abs(value));
        }

        int max = 0;
        if(pq.isEmpty()) max = nq.peek();
        else if(nq.isEmpty()) max = pq.peek();
        else max = Math.max(pq.peek(), nq.peek());

        int ans = 0;
        while(!pq.isEmpty()){
            int value = pq.poll();
            for(int i = 0; i < M - 1; i++){
                pq.poll();
                if(pq.isEmpty()) break;
            }
            ans += value * 2;
        }
        while(!nq.isEmpty()){
            int value = nq.poll();
            for(int i = 0; i < M - 1; i++){
                nq.poll();
                if(nq.isEmpty()) break;
            }
            ans += value * 2;
        }

        ans -= max;
        System.out.println(ans);
    }
}
