package baekjoon.graph.boj18352;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj18352 {
    public static int N, M, K, X;
    public static int visited[];
    public static List<Integer> ans;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj18352/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arrayList = new ArrayList[N + 1];
        visited = new int[N + 1];
        ans = new ArrayList<>();
        Arrays.fill(visited, -1);

        for(int i = 1; i < N + 1; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arrayList[start].add(end);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);
        visited[X] = 0;
        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int value : arrayList[now]){
                if(visited[value] == -1){
                    visited[value] = visited[now] + 1;
                }else{
                    int tmp = visited[now] + 1;
                    if(tmp > visited[value])    continue;
                    visited[value] = tmp;
                }
                queue.offer(value);
            }

        }
        int tmp = 0;
        for(int i = 1; i < visited.length; i++){
            if(visited[i] == K){
                ans.add(i);
            }
        }

        if(ans.isEmpty()){
            System.out.println(-1);
            return;
        }

        Collections.sort(ans);
        for(int value : ans){
            sb.append(value).append("\n");
        }

        System.out.println(sb);
    }
}
