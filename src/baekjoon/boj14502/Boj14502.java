package baekjoon.boj14502;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14502 {
    static int N, M, max = Integer.MIN_VALUE;
    static int[][] map, newMap;
    static boolean[][] visit;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static Queue<Point> virusQueue;
    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj14502/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];


        virusQueue = new LinkedList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){ // 바이러스 위치 큐에 저장
                    virusQueue.offer(new Point(i, j));
                }

            }
        }
        // 벽 세울 구간 3군데 정하기
        select(0, 0, 0);

        System.out.println(max);

    }

    public static void select(int count, int r, int c){

        if(count == 3){
            // 벽 세울 구간 정했으니까 바이러스 퍼트리자!

            spread();
            // 안전영역 크기 구하기
            int size = countSafe();
            max = Math.max(size, max);
            return;
        }

        for(int i = r; i < N; i++){
            for(int j = c; j < M; j++){
                if(map[i][j] != 0)  continue;
                map[i][j] = 1;
                select(count + 1, i, j + 1);
                map[i][j] = 0;
            }
            c = 0;
        }

    }

    // 바이러스 퍼트리기
    public static void spread(){
        visit = new boolean[N][M];
        newMap = new int[N][M];
        Queue<Point> tmpQueue = new LinkedList<>();

        for(Point virus : virusQueue){
            tmpQueue.offer(virus);
        }

        for(int i = 0; i < N; i++){
            newMap[i] = map[i].clone();
        }

        while(!tmpQueue.isEmpty()){
            Point cur = tmpQueue.poll();
            int r = cur.r;
            int c = cur.c;

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 범위 체크
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || newMap[nr][nc] != 0)  continue;

                // 바이러스 퍼트리기
                newMap[nr][nc] = 2;
                tmpQueue.offer(new Point(nr, nc));

            }

        }

    }

    // 안전영역 크기 구하기
    public static int countSafe(){
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(newMap[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }


}
