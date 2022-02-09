package baekjoon.boj13335;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13335 {
    static int N, W, L;
    static Queue<Truck> queue;
    static Queue<Truck> bridge;

    public static class Truck{
        int weight;
        int time;

        Truck(int weight, int time){
            this.weight = weight;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj13335/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        queue = new LinkedList<>();
        bridge = new LinkedList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            queue.offer(new Truck(Integer.parseInt(st.nextToken()), 0));
        }

        int count = 0, weight = 0;

        while(!queue.isEmpty() || !bridge.isEmpty()){
            count++;

            if(!bridge.isEmpty() && count - bridge.peek().time >= W)
                weight -= bridge.poll().weight;

            if(!queue.isEmpty() && weight + queue.peek().weight <= L){
                Truck truck = queue.poll();
                weight += truck.weight;

                bridge.add(new Truck(truck.weight, count));
            }
        }
        System.out.println(count);

    }
}
