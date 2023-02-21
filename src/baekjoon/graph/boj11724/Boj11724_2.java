package baekjoon.graph.boj11724;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj11724_2 {
    public static int N, M, count = 0;
    public static boolean[] visited;
    public static ArrayList<Integer>[] arrayList;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj11724/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    public static void dfs(int start){
        if(visited[start])  return;

        visited[start] = true;
        for(int value : arrayList[start]){
            if(!visited[value])
                dfs(value);
        }
    }
}
