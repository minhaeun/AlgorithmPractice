package baekjoon.graph.boj1753;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1753 {
    static int V, E, K;
    static ArrayList<Node> arrayList[];
    static int dist[];
    static boolean visit[];


    static class Node implements Comparable<Node>{
        int idx, w;
        Node(int idx, int w){
            this.idx = idx;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/graph/boj1753/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new int[V + 1];
        arrayList = new ArrayList[V + 1];
        visit = new boolean[V + 1];

        for(int i = 1; i <= V; i++){
            arrayList[i] = new ArrayList<>();
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        K = Integer.parseInt(br.readLine());
        dist[K] = 0;
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            arrayList[from].add(new Node(to, dis));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(K, 0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(visit[node.idx]) continue;
            visit[node.idx] = true;
            for(Node n : arrayList[node.idx]){
                if(dist[n.idx] > dist[node.idx] + n.w){
                    dist[n.idx] = dist[node.idx] + n.w;
                    pq.add(new Node(n.idx, dist[n.idx]));
                }
            }
        }

        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE){
                sb.append("INF\n");
            }else{
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb.toString());


    }
}
