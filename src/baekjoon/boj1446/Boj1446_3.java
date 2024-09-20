package baekjoon.boj1446;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj1446_3 {
    public static int N, D, dist[];
    public static ArrayList<Node>[] arrayList;
    public static class Node{
        int end, weight;
        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1446/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList[10001];
        dist = new int[10001];

        for(int i = 0; i < 10001; i++){
            dist[i] = i;
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arrayList[s].add(new Node(e, w));
        }

        dfs(0);
        System.out.println(dist[D]);
    }

    public static void dfs(int start){
        if(start > D) return;
        if(dist[start + 1] > dist[start] + 1) dist[start + 1] = dist[start] + 1;
        for(Node node : arrayList[start]){
            int end = node.end;
            int weight = node.weight;
            if(dist[start] + weight < dist[end]) dist[end] = dist[start] + weight;
        }
        dfs(start + 1);
    }
}
