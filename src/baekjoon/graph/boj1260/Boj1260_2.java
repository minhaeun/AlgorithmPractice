package baekjoon.graph.boj1260;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1260_2 {
    public static int N, M, V;
    public static boolean visited[];
    public static ArrayList<Integer> arrayList[];
    public static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj1260/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        arrayList = new ArrayList[N + 1];

        for(int i = 1; i < N + 1; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arrayList[s].add(e);
            arrayList[e].add(s);
        }

        for(int i = 1; i < N + 1; i++){
            Collections.sort(arrayList[i]);
        }

        dfs(V);
        visited = new boolean[N + 1];
        sb.append("\n");
        bfs(V);
        System.out.println(sb);

    }

    public static void dfs(int start){
        sb.append(start).append(" ");
        visited[start] = true;

        for(int value : arrayList[start]){
            if(!visited[value]){
                dfs(value);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now).append(" ");
            for(int value : arrayList[now]){
                if(!visited[value]){
                    queue.add(value);
                    visited[value] = true;
                }
            }
        }


    }
}
