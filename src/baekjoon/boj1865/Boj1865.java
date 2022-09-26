package baekjoon.boj1865;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1865 {
    static int N, M, W, INF = Integer.MAX_VALUE / 10;
    static int[] distance;

    public static class Vertex {
        int start, end, minDistance;

        Vertex(int start, int end, int minDistance) {
            this.start = start;
            this.end = end;
            this.minDistance = minDistance;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj1865/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            ArrayList<Vertex> vertexList = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int minDistance = Integer.parseInt(st.nextToken());
                vertexList.add(new Vertex(start, end, minDistance));
                vertexList.add(new Vertex(end, start, minDistance));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int minDistance = Integer.parseInt(st.nextToken());
                vertexList.add(new Vertex(start, end, minDistance * (-1)));
            }

            distance = new int[N + 1];
            boolean flag = false;
            Arrays.fill(distance, INF);
            distance[1] = 0;
            OUTER: for (int j = 1; j <= N; j++) {
                flag = false;
                for (Vertex vertex : vertexList) {
                    if (distance[vertex.end] > distance[vertex.start] + vertex.minDistance) {
                        if (j == N) {
                            flag = true;
                            break OUTER;
                        }
                        distance[vertex.end] = distance[vertex.start] + vertex.minDistance;
                        flag = true;
                    }
                }
                if (!flag) break;
            }

            sb.append(flag ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);

    }
}
