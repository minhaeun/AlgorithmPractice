package baekjoon.boj5972;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj5972_2 {
    public static int N, M, arr[];
    public static boolean[] visited;
    public static ArrayList<Node>[] arrayList;
    public static class Node{
        int end, weight;
        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj5972/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        Arrays.fill(arr, 50000001);
        arr[1] = 0;
        visited = new boolean[N + 1];
        arrayList = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arrayList[start].add(new Node(end, weight));
            arrayList[end].add(new Node(start, weight));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });

        pq.offer(new Node(1, 0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int end = now.end;
            if(visited[end]) continue;
            visited[end] = true;

            for(Node node : arrayList[end]){
                if(arr[node.end] <= arr[end] + node.weight) continue;
                arr[node.end] = arr[end] + node.weight;
                pq.offer(new Node(node.end, arr[node.end]));
            }
        }
        System.out.println(arr[N]);

    }
}
