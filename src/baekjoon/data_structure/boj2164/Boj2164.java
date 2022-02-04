package baekjoon.data_structure.boj2164;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2164 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj2164/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < N; i++){
            queue.add(i+1);
        }

        while(queue.size() != 1){
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.print(queue.poll());
    }
}
