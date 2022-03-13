package baekjoon.graph.boj11724;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj11724 {
    static int N, M;
    static ArrayList<Integer>[] arrayList;
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("baekjoon/graph/boj11724/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int count = 0;
        visit = new boolean[N + 1];
        arrayList = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList[a].add(b);
            arrayList[b].add(a);
        }

        for(int i = 1; i <= N; i++){
            if(!visit[i]){
                dfs(i);
                count++;
            }
        }
        sb.append(count);
        System.out.println(sb.toString());

    }

    public static void dfs(int num){
        if(visit[num]) return;
        visit[num] = true;
        for(int n : arrayList[num]){
            if(!visit[n]){
                dfs(n);
            }
        }
    }
}
