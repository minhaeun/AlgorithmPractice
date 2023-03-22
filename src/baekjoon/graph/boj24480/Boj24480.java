package baekjoon.graph.boj24480;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj24480 {
    public static int N, M, R, count = 1;
    public static ArrayList<Integer>[] arrayList;
    public static int visited[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj24480/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList[N + 1];
        visited = new int[N + 1];

        for(int i = 1; i < N + 1; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arrayList[u].add(v);
            arrayList[v].add(u);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(arrayList[i], Collections.reverseOrder());
        }
        visited[R] = 1;
        dfs(R);

        for(int i = 1; i <= N; i++){
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int start){
        for(int value : arrayList[start]){
            if(visited[value] != 0) continue;
            visited[value] = ++count;
            dfs(value);
        }
    }
}
