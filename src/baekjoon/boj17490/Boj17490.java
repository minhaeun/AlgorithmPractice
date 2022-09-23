package baekjoon.boj17490;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj17490 {
    static int N;
    static int M;
    static int[] parents;
    static Long K;
    static Edge[] edgeList;

    public static void makeSet() {
        parents = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parents[i] = i;
        }
    }

    public static int findSet(int a) {
        if (a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("./src/baekjoon/boj17490/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        edgeList = new Edge[2 * N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(0, i + 1, weight);
        }
        int index = 1;
        int i;

        int[][] arr = new int[M][2];
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if(from > to && to != 1) {
                int tmp = from;
                from = to;
                to = tmp;
            }

            arr[j][0] = from;
            arr[j][1] = to;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        for (i = 0; i < M; i++) {
            int from = arr[i][0];
            int to = arr[i][1];

            while (index < from) {
                int tmp = index == N ? 1 : index + 1;
                edgeList[N + index - 1] = new Edge(index, tmp, 0);
                index++;
            }
            edgeList[N + from - 1] = new Edge(from, to, Integer.MAX_VALUE);
            index++;
        }

        if (M == 0 || M == 1) {
            System.out.println("YES");
            return;
        }

        while (index <= N) {
            int tmp = index == N ? 1 : index + 1;
            edgeList[N + index - 1] = new Edge(index, tmp, 0);
            index++;
        }


        Arrays.sort(edgeList);
        makeSet();

        long result = 0, count = 0;

        for (Edge edge : edgeList) {
            if (union(edge.from, edge.to)) {
                result += edge.weight;
                if (++count == N) break;
            }
        }


        if (result <= K) sb.append("YES");
        else sb.append("NO");

        System.out.println(sb);

    }

    public static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}

