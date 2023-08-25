package baekjoon.data_structure.boj2164;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2164_3 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj2164/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue  = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            queue.offer(i);
        }

        while(queue.size() > 1){
            queue.poll();
            int value = queue.poll();
            queue.offer(value);
        }
        System.out.println(queue.poll());
    }
}
