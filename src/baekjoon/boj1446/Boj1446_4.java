package baekjoon.boj1446;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1446_4 {
    public static int N, D, arr[];
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
        arr = new int[10001];
        Arrays.fill(arr, 10001);
        arr[0] = 0;
        for(int i = 0; i < 10001; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(end > D) continue;
            if(end - start < weight) continue;
            arrayList[start].add(new Node(end, weight));
        }


        dfs(0);
        System.out.println(arr[D]);
    }

    public static void dfs(int start){
        if(start > D) return;
        if(arr[start] + 1 < arr[start + 1]){
            arr[start + 1] = arr[start] + 1;
        }
        for(Node node : arrayList[start]){
            int end = node.end;
            int weight = node.weight;
            if(arr[start] + weight < arr[end]){
                arr[end] = arr[start] + weight;
            }
        }

        dfs(start + 1);

    }
}
