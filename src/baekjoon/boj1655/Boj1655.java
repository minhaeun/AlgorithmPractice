package baekjoon.boj1655;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj1655 {
    static int N;
    static PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    static PriorityQueue<Integer> pq2 = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj1655/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            pq1.offer(num);

            if (i % 2 != 0) {
                pq2.offer(pq1.poll());
            }else{
                if(num <= pq2.peek()){
                    pq1.offer(pq2.poll());
                    pq2.offer(pq1.poll());
                }

            }
            sb.append(pq2.peek()).append("\n");
        }

        System.out.println(sb.toString());

    }
}
