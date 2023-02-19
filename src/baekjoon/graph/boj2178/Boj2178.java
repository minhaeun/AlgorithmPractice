package baekjoon.graph.boj2178;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Boj2178 {
    public static int N, M, map[][];
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static boolean visited[][];

    public static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj2178/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int len = str.length();
            for(int j = 0; j < len; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(new Node(0, 0));

        System.out.println(map[N - 1][M - 1]);
    }

    public static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        visited[node.r][node.c] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int r = now.r;
            int c = now.c;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                queue.add(new Node(nr, nc));
                map[nr][nc] = map[r][c] + 1;

            }

        }

    }
}
