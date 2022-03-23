package baekjoon.boj2638;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2638 {

    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static int count, time;
    public static class Point{
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2638/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)
                    count++;
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        while(count > 0){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point cur = queue.poll();
                map[cur.r][cur.c] = 10;

                queue.add(cur);
            }
            while(!queue.isEmpty()){
                Point cur = queue.poll();

                for(int d = 0; d < 4; d++){
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != 0)  continue;

                    queue.add(new Point(nr, nc));
                    map[nr][nc] = 10;
                }
            }

            for(int i = 1; i < N - 1; i++){
                for(int j = 1; j < M - 1; j++){
                    if(map[i][j] == 1 && (map[i - 1][j] + map[i + 1][j] + map[i][j - 1] + map[i][j + 1]) >= 20){
                        queue.add(new Point(i, j));
                    }
                }
            }
            count -= queue.size();
            time++;
        }
        System.out.println(time);
    }
}
