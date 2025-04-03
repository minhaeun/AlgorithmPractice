package baekjoon.boj13975;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj13975 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj13975/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            PriorityQueue<Long> pq = new PriorityQueue<>();
            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < K; i++){
                pq.add(Long.parseLong(st.nextToken()));
            }
            Long sum = 0l;
            while(pq.size() > 1){
                Long a = pq.poll();
                Long b = pq.poll();
                sum += a + b;
                pq.add(a + b);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
