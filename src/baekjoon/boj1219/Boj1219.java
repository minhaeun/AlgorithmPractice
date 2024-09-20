package baekjoon.boj1219;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;



public class Boj1219 {
    static int A, B, N, M;
    static long[] dist, val;
    static long[][] adj;
    static final int INF = -100 * 1000000, GEE = 100 * 1000000;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj1219/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new long[N];
        val = new long[N];
        Arrays.fill(dist, INF);

        adj = new long[N][N];
        for (long[] arr : adj)
            Arrays.fill(arr, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adj[from][to] = Math.max(adj[from][to], -weight);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }

        OhMinSik();
    }

    public static void OhMinSik() {
        dist[A] = val[A];

        for (int n = 0; n < N + 100; n++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dist[i] == INF || adj[i][j] == INF) continue;
                    else if (dist[i] == GEE) dist[j] = GEE;
                    else if (dist[i] + adj[i][j] + val[j] > dist[j]) {
                        dist[j] = dist[i] + adj[i][j] + val[j];
                        if (n >= N - 1) dist[j] = GEE;
                    }
                }
            }
        }

        if (dist[B] == INF) System.out.println("gg");
        else if (dist[B] == GEE) System.out.println("Gee");
        else System.out.println(String.valueOf(dist[B]));

        return;
    }
}