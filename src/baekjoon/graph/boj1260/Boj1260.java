package baekjoon.graph.boj1260;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1260 {
    static int N, M, V;
    static PriorityQueue<Integer>[] pq1;
    static PriorityQueue<Integer>[] pq2;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/graph/boj1260/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1];

        pq1 = new PriorityQueue[N + 1];
        pq2 = new PriorityQueue[N + 1];
        for(int i = 0; i < N + 1; i++){
            pq1[i] = new PriorityQueue<>();
            pq2[i] = new PriorityQueue<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            pq1[node1].add(node2);
            pq1[node2].add(node1);

            pq2[node1].add(node2);
            pq2[node2].add(node1);
        }


        dfs(V);
        Arrays.fill(visit, false);
        System.out.println();
        bfs(V);

    }

    public static void dfs(int start){
        // 첫번째 값
        if(visit[start])    return;

        visit[start] = true;
        System.out.print(start + " ");


        while(!pq1[start].isEmpty()){
            int value = pq1[start].poll();
            if(!visit[value]){
                dfs(value);
            }
        }

    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visit[start] = true;

        while (!queue.isEmpty()) {
            start = queue.poll();
            System.out.print(start + " ");

            while (!pq2[start].isEmpty()) {
                int value = pq2[start].poll();
                if (!visit[value]) {
                    queue.add(value);
                    visit[value] = true;
                }
            }


        }

    }


}
