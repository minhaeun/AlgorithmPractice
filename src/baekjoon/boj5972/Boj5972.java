package baekjoon.boj5972;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj5972 {
    public static class Node implements Comparable<Node>{
        int e, cost;
        public Node(int e, int cost){
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node){
            return this.cost - node.cost;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj5972/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Node>[] lists = new ArrayList[N + 1];
        int[] arr = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Arrays.fill(arr, 50000001);

        for(int i = 1; i <= N; i++){
            lists[i] = new ArrayList<>();
        }


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            lists[A].add(new Node(B, C));
            lists[B].add(new Node(A, C));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(1, 0));
        arr[1] = 0;

        while(!queue.isEmpty()){
            Node now = queue.poll();
            int e = now.e;
            if(visited[e])  continue;
            visited[e] = true;
            for(Node value : lists[e]){
                if(value.cost + arr[e] >= arr[value.e])   continue;
                arr[value.e] = value.cost + arr[e];
                queue.offer(new Node(value.e, arr[value.e]));
            }
        }

        System.out.println(arr[N]);
    }
}
