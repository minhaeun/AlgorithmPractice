package baekjoon.boj1715;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Boj1715 {
        static int N;
        static PriorityQueue<Integer> pq;
        public static void main(String[] args) throws IOException {
            System.setIn(new FileInputStream("./src/baekjoon/boj1715/input.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());

            pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                pq.add(Integer.parseInt(br.readLine()));
            }
            int sum = 0, total = 0, answer = 0;
            for(int i = 0; i < N -1; i++) {
                sum = pq.poll();
                sum += pq.poll();

                pq.add(sum);
                total += sum;
            }

            System.out.println(total);
        }

}
