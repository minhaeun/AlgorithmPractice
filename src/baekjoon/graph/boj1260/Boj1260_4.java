package baekjoon.graph.boj1260;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1260_4 {
    public static int N, M, V;
    public static boolean[] check;
    public static ArrayList<Integer>[] arrayList;
    public static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj1260/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList[N + 1];

        for(int i = 1; i < N + 1; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arrayList[v1].add(v2);
            arrayList[v2].add(v1);
        }

        for(int i = 1; i < N + 1; i++){
            Collections.sort(arrayList[i]);
        }


        check = new boolean[N + 1];
        check[V] = true;
        sb.append(V).append(" ");
        dfs(V);
        sb.append("\n");
        bfs();
        System.out.println(sb);
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        queue.offer(V);
        visited[V] = true;
        sb.append(V).append(" ");

        while(!queue.isEmpty()){
            int num = queue.poll();

            for(int value : arrayList[num]){
                if(visited[value]) continue;
                visited[value] = true;
                sb.append(value).append(" ");
                queue.add(value);
            }
        }
    }

    public static void dfs(int start){

        for(int value : arrayList[start]){
            if(check[value]) continue;
            check[value] = true;
            sb.append(value).append(" ");
            dfs(value);
        }

    }
}
