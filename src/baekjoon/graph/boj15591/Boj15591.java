package baekjoon.graph.boj15591;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj15591 {
    static int N, Q;
    static int p, q, r, k, v;
    static ArrayList<Node>[] arrayList;
    static class Node{
        int num, weight;
        Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/graph/boj15591/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            arrayList[p].add(new Node(q, r));
            arrayList[q].add(new Node(p, r));
        }

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            Queue<Integer> queue = new LinkedList<>();
            queue.add(v);
            boolean[] visit = new boolean[N + 1];
            visit[v] = true;

            int count = 0;
            while(!queue.isEmpty()){
                int current = queue.poll();

                for(Node node : arrayList[current]){
                    if(visit[node.num]) continue;
                    if(node.weight < k) continue;
                    queue.add(node.num);
                    visit[node.num] = true;
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());



    }
}
