package baekjoon.boj1417;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Boj1417 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1417/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(n-- > 1)  pq.add(Integer.parseInt(br.readLine()));
        int count = 0;
        while(!pq.isEmpty() && pq.peek() >= a){
            count++;
            a++;
            pq.add(pq.poll() - 1);
        }
        System.out.println(count);
    }
}
