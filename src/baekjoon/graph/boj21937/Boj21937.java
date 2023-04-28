package baekjoon.graph.boj21937;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj21937 {
    public static int N, M, count;
    public static ArrayList<Integer>[] arrayList;
    public static boolean[] visited;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj21937/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arrayList[B].add(A);
        }
        int X = Integer.parseInt(br.readLine());

        visited[X] = true;
        dfs(X);
        System.out.println(count);
    }
    public static void dfs(int start){

        for(int value : arrayList[start]){
            if(visited[value])  continue;
            visited[value] = true;
            count++;
            dfs(value);
        }
    }
}
