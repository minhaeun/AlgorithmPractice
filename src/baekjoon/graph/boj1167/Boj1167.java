package baekjoon.graph.boj1167;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1167 {
    public static int V, distance[];
    public static boolean visited[];
    public static ArrayList<Edge>[] arrayList;
    public static class Edge{
        int e;
        int value;
        public Edge(int e, int value){
            this.e = e;
            this.value = value;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj1167/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        arrayList = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        distance = new int[V + 1];

        for(int i = 1; i <= V; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < V; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int v = Integer.parseInt(st.nextToken());
            int e;
            while((e = Integer.parseInt(st.nextToken())) != -1){
                arrayList[v].add(new Edge(e, Integer.parseInt(st.nextToken())));
            }
        }

        bfs(1);
        int max = 1;
        for(int i = 2; i < V + 1; i++){
            if(distance[max] < distance[i]) max = i;
        }
        distance = new int[V + 1];
        visited = new boolean[V + 1];
        bfs(max);
        Arrays.sort(distance);
        System.out.println(distance[V]);

    }
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(Edge edge : arrayList[now]){
                if(visited[edge.e]) continue;
                visited[edge.e] = true;
                queue.offer(edge.e);
                distance[edge.e] = distance[now] + edge.value;
            }
        }
    }
}
