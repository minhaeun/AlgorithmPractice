package baekjoon.boj7569;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7569 {
    public static int M, N, H, count;
    public static int map[][][];
    public static int[] dr = {-1, 1, 0, 0, 0, 0}; // 상, 하, 좌, 우
    public static int[] dc = {0, 0, -1, 1, 0, 0};
    public static int[] dh = {0, 0, 0, 0, -1, 1}; // 위, 아래
    public static Queue<Tomato> queue;
    public static class Tomato{
        int r, c, h;
        public Tomato(int h, int r, int c){
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj7569/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        queue = new LinkedList<>();


        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k = 0; k < M; k++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1)   queue.offer(new Tomato(i, j, k));
                    if(map[i][j][k] == 0)   count++;
                }
            }
        }

        if(count == 0){
            System.out.println(0);
            return;
        }

        while(!queue.isEmpty()){
            Tomato now = queue.poll();
            int r = now.r;
            int c = now.c;
            int h = now.h;

            for(int d = 0; d < 6; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                int nh = h + dh[d];

                if(nr < 0 || nr >= N || nc < 0 || nc >= M || nh < 0 || nh >= H || map[nh][nr][nc] != 0) continue;
                queue.offer(new Tomato(nh, nr, nc));
                map[nh][nr][nc] = map[h][r][c] + 1;
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < M; k++){
                    if(map[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, map[i][j][k]);
                }
            }
        }

        System.out.println(max-1);

    }
}
