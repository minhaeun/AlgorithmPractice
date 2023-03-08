package baekjoon.graph.boj1325;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1325_2 {
    public static int N, M, ans[];
    public static boolean visited[];
    public static ArrayList<Integer>[] arrayList;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj1325/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList[N + 1];
        ans = new int[N + 1];


        for(int i = 1; i < N + 1; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arrayList[A].add(B);
        }

        for(int i = 1; i < N + 1; i++){
            visited = new boolean[N + 1];
            bfs(i);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i < N + 1; i++){
            max = Math.max(max, ans[i]);
        }

        for(int i = 1; i < N + 1; i++){
            if(ans[i] == max)   sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int value : arrayList[now]){
                if(visited[value])  continue;
                visited[value] = true;
                queue.offer(value);
                ans[value]++;
            }
        }
    }
}
