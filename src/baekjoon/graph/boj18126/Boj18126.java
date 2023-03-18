package baekjoon.graph.boj18126;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj18126 {
    public static int N;
    public static long ans;
    public static ArrayList<Node>[] arrayList;
    public static boolean visited[];
    public static class Node{
        int e;
        long l;
        public Node(int e, long l){
            this.e = e;
            this.l = l;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj18126/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arrayList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++ ){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            arrayList[s].add(new Node(e, l));
            arrayList[e].add(new Node(s, l));
        }
        visited[1] = true;
        dfs(1, 0);

        System.out.println(ans);
    }

    public static void dfs(int start, long count){
        if(ans < count) ans = count;

        for(Node node : arrayList[start]){
            if(visited[node.e]) continue;
            visited[node.e] = true;
            dfs(node.e, count + node.l);
        }
    }
}
