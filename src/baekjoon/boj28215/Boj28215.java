package baekjoon.boj28215;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj28215 {
    public static int N, K, min = Integer.MAX_VALUE;
    public static boolean[] visited;
    public static Point[] points;
    public static class Point{
        int r, c;
        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj28215/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        points = new Point[N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            points[i] = new Point(r, c);
        }
        choice(0, 0);
        System.out.println(min);
    }
    public static void choice(int start, int count){
        if(count == K){
            int maxDist = 0;
            for(int i = 0; i < N; i++){
                if(visited[i]) continue;
                int minDist = Integer.MAX_VALUE;
                for(int j = 0; j < N; j++){
                    if(!visited[j]) continue;
                    int dist = Math.abs(points[i].r - points[j].r) + Math.abs(points[i].c - points[j].c);
                    minDist = Math.min(minDist, dist);
                }
                maxDist = Math.max(maxDist, minDist);
            }
            min = Math.min(maxDist, min);
            return;
        }

        for(int i = start; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            choice(i + 1, count + 1);
            visited[i] = false;
        }
    }
}
