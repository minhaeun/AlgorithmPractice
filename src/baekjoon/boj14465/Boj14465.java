package baekjoon.boj14465;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14465 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj14465/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < B; i++){
            int index = Integer.parseInt(br.readLine());
            arr[index] = true;
        }

        int min = Integer.MAX_VALUE, count = 0;
        for(int i = 1; i <= K; i++){
            queue.offer(i);
            if(arr[i]) count++;
        }
        min = Math.min(min, count);

        for(int i = K + 1; i <= N; i++){
            int index = queue.poll();
            if(arr[index]) count--;
            queue.offer(i);
            if(arr[i]) count++;
            min = Math.min(count, min);
        }
        System.out.println(min);
    }
}
