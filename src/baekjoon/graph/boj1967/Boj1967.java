package baekjoon.graph.boj1967;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1967 {
    public static int N, max;
    public static ArrayList<Node>[] arrayList;
    public static boolean visited[];
    public static class Node{
        int num, weight;
        Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj1967/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arrayList = new ArrayList[N + 1];
        ArrayList<Integer> leaves = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arrayList[p].add(new Node(c, w));
            arrayList[c].add(new Node(p, w));
        }

        for(int i = 0; i < arrayList.length; i++){
            if(arrayList[i] == null || arrayList[i].size() != 1)    continue;
            leaves.add(i);
        }

        for(int value : leaves){
            visited = new boolean[N + 1];
            visited[value] = true;
            dfs(value, 0);
        }
        System.out.println(max);
    }
    public static void dfs(int start, int weight){

        for(Node value : arrayList[start]){
            if(visited[value.num])  continue;
            visited[value.num] = true;
            dfs(value.num, weight + value.weight);
        }
        max = Math.max(max, weight);

    }
}
