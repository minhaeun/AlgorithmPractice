package baekjoon.boj1194;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1194 {
    static int N, M;
    static char[][] map;
    static boolean[][][] visit;
    static Queue<Point> q = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static class Point{
        int r, c, key;
        Point(int r, int c, int key){
            this.r = r;
            this.c = c;
            this.key = key;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1194/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M][64];

        for(int i = 0; i < N; i++){
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = line[j];

                if(map[i][j] == '0'){
                    q.offer(new Point(i, j, 0));
                    visit[i][j][0] = true;
                    map[i][j] = '.';
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int time = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            time++;

            for(int i = 0 ; i < size ; ++i) {
                Point cur = q.poll();
                int r = cur.r;
                int c = cur.c;
                int key = cur.key;

                for(int d= 0 ; d < 4 ; ++d) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    int nk = key;

                    if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if(visit[nr][nc][key] || map[nr][nc] == '#') continue;

                    if(map[nr][nc] == '1') return time;

                    else if(map[nr][nc] >= 'a' && map[nr][nc] <= 'z') {
                        int ck = 1 << (map[nr][nc] - 'a');
                        if((key & ck) != ck) nk |= ck;
                    } else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'Z') {
                        int cd = 1 << (map[nr][nc] - 'A');
                        if((key & cd) != cd) continue;
                    }

                    q.offer(new Point(nr, nc, nk));
                    visit[nr][nc][key] = true;
                }
            }
        }
        return -1;
    }
}
