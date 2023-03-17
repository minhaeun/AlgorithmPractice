package baekjoon.graph.boj2583;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2583 {
    public static int M, N, K;
    public static List<Integer> ans;
    public static boolean visited[][];
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static class Point{
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj2583/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[M][N];
        ans = new ArrayList<>();


        for(int k = 0; k < K; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int c1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());


            for(int i = r1; i < r2; i++){
                for(int j = c1; j < c2; j++){
                    if(visited[i][j])   continue;
                    visited[i][j] = true;
                }
            }
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j])   continue;
                Queue<Point> queue = new LinkedList<>();
                queue.offer(new Point(i, j));
                visited[i][j] = true;
                int count = 1;
                while (!queue.isEmpty()){
                    Point now = queue.poll();
                    int r = now.r;
                    int c = now.c;
                    for(int d = 0; d < 4; d++){
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if(nr < 0 || nr >= M || nc < 0 || nc >= N || visited[nr][nc])   continue;
                        visited[nr][nc] = true;
                        count++;
                        queue.offer(new Point(nr, nc));
                    }

                }
                ans.add(count);
            }
        }
        sb.append(ans.size()).append("\n");

        Collections.sort(ans);
        for(int value : ans){
            sb.append(value).append(" ");
        }

        System.out.println(sb);

    }
}
