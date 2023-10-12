package baekjoon.boj1238;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1238 {
    public static int N, M, X;
    public static ArrayList<Node>[] list;
    public static class Node implements Comparable<Node> {
        int end, time;
        public Node(int end, int time){
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1238/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for(int i = 1; i < N+ 1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, time));
        }

        int max = 0;
        for(int i = 1; i < N + 1; i++){
            if(i == X)  continue;
            int go = dijkstra(i, X);
            int back = dijkstra(X, i);

            max = Math.max(go + back, max);
        }
        System.out.println(max);
    }

    public static int dijkstra(int s, int e){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 1000001);
        dist[s] = 0;
        pq.offer(new Node(s, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            int end = now.end;
            if(visited[end])    continue;
            visited[end] = true;
            for(Node node : list[end]){
                if(visited[node.end])   continue;
                if(dist[node.end] <= dist[end] + node.time)  continue;
                dist[node.end] = dist[end] + node.time;
                pq.offer(new Node(node.end, dist[node.end]));
            }
        }
        return dist[e];
    }
}
