package baekjoon.boj10282;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj10282 {
    public static class Node{
        int a, s;
        public Node(int a, int s) {
            this.a = a;
            this.s = s;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj10282/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        ArrayList<Node>[] list;

        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list = new ArrayList[n + 1];
            for(int i = 0; i < n + 1; i++){
                list[i] = new ArrayList<>();
            }

            for(int i = 0; i < d; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                list[b].add(new Node(a, s));
            }


            PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.s - o2.s;
                }
            });
            int count = 0, time = 0;
            pq.offer(new Node(c, 0));
            boolean[] visited = new boolean[n + 1];

            while(!pq.isEmpty()){
                Node now = pq.poll();
                if(visited[now.a]) continue;
                visited[now.a] = true;
                count++;
                time = Math.max(time, now.s);

                for(int i = 0; i < list[now.a].size(); i++){
                    Node next = list[now.a].get(i);
                    if(visited[next.a]) continue;
                    pq.offer(new Node(next.a, now.s + next.s));
                }
            }
            sb.append(count).append(" ").append(time).append("\n");
        }
        System.out.println(sb);
    }
}
