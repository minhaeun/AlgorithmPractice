package baekjoon.graph.boj1260;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1260_3 {
    public static int N, M, V;
    public static ArrayList<Integer>[] arrayList;
    public static boolean visited[];
    public static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj1260/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arrayList[s].add(e);
            arrayList[e].add(s);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(arrayList[i]);
        }

        visited = new boolean[N + 1];
        visited[V] = true;
        sb.append(V).append(" ");
        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        sb.append(V).append(" ");
        visited[V] = true;
        bfs(V);
        System.out.println(sb);
    }

    public static void dfs(int start){
        for(int value : arrayList[start]){
            if(visited[value])  continue;
            visited[value] = true;
            sb.append(value).append(" ");
            dfs(value);
        }
    }
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int value : arrayList[now]){
                if(visited[value])  continue;
                visited[value] = true;
                queue.offer(value);
                sb.append(value).append(" ");
            }
        }
    }
}
