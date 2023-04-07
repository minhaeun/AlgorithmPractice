package baekjoon.boj17471;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj17471 {
    public static int N, min = Integer.MAX_VALUE;
    public static boolean visited[];
    public static Node[] nodes;
    public static ArrayList<Node>[] arrayList;

    public static class Node {
        int num, population, flag = 0;

        Node(int num, int population) {
            this.num = num;
            this.population = population;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj17471/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N + 1];
        arrayList = new ArrayList[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            int population = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(i, population);
        }

        for (int i = 1; i <= N; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                arrayList[i].add(nodes[tmp]);
            }
        }

        for (int i = 1; i <= N / 2; i++) {
            visited = new boolean[N + 1];
            comb(1, i);
        }

        if(min == Integer.MAX_VALUE){
            min = -1;
        }

        System.out.println(min);

    }

    public static void comb(int start, int count) {
        if (count == 0) {
            if (check(0) + check(1) == N) {
                min = Math.min(cal(), min);
            }
            return;
        }

        for (int i = start; i <= N; i++) {
            nodes[i].flag = 1;
            comb(i + 1, count - 1);
            nodes[i].flag = 0;
        }

    }

    public static int check(int flag) {
        int n;
        for (n = 1; n <= N; n++) {
            if (nodes[n].flag == flag) break;
        }
        boolean[] visited = new boolean[N + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(nodes[n]);
        visited[n] = true;
        int cnt = 1;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int num = now.num;
            for(Node node : arrayList[num]){
                if(visited[node.num] || nodes[node.num].flag != flag)  continue;
                visited[node.num] = true;
                queue.offer(node);
                cnt++;
            }
        }


        return cnt;
    }

    public static int cal() {
        int a = 0, b = 0;
        for (int i = 1; i <= N; i++) {
            if (nodes[i].flag == 1) a += nodes[i].population;
            else b += nodes[i].population;
        }

        return Math.abs(a - b);
    }
}
