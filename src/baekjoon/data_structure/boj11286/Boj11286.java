package baekjoon.data_structure.boj11286;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj11286 {
    static int N;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/data_structure/boj11286/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());


        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)) return o1-o2;
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(br.readLine());

            if(value == 0){
                if(pq.isEmpty())  sb.append(0).append("\n");
                else    sb.append(pq.poll()).append("\n");
            }
            else    pq.offer(value);
        }
        System.out.println(sb.toString());



    }
}
