package baekjoon.graph.boj24447;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj24447 {
    public static int N, M, R, visited[], depth[], count = 1;
    public static ArrayList<Integer>[] arrayList;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj24447/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new int[N + 1];
        depth = new int[N + 1];
        arrayList = new ArrayList[N + 1];
        Arrays.fill(depth, -1);

        for (int i = 1; i <= N; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arrayList[u].add(v);
            arrayList[v].add(u);
        }

        visited[R] = 1;
        depth[R] = 0;
        bfs(R);

        long sum = 0;
        for(int i = 1; i <= N; i++){
            sum += (long) visited[i] * depth[i];
        }
        System.out.println(sum);
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int value : arrayList[now]){
                if(visited[value] != 0)    continue;
                depth[value] = depth[now] + 1;
                visited[value] = ++count;
                queue.offer(value);
            }
        }
    }
}
