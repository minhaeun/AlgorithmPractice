package baekjoon.boj4179;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj4179 {
    public static int dr[] = {-1, 1, 0, 0};
    public static int dc[] = {0, 0, -1, 1};
    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj4179/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];

        Point J = null;
        Queue<Point> road = new LinkedList<>();
        Queue<Point> fire = new LinkedList<>();
        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'J')    J = new Point(i, j);
                else if(map[i][j] == 'F')    fire.offer(new Point(i, j));
            }
        }



        road.offer(J);
        map[J.r][J.c] = '#';

        int time = 1;
        boolean flag = false;
        OUTER : while(!road.isEmpty()){
            int fireLen = fire.size();
            for(int i = 0; i < fireLen; i++){
                Point now = fire.poll();
                int r = now.r;
                int c = now.c;
                for(int d = 0; d < 4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '#' || map[nr][nc] == 'F')  continue;
                    map[nr][nc] = 'F';
                    fire.offer(new Point(nr, nc));
                }
            }

            int roadLen = road.size();
            for(int i = 0; i < roadLen; i++){
                Point now = road.poll();
                int r = now.r;
                int c = now.c;

                for(int d = 0; d < 4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nr >= R || nc < 0 || nc >= C){
                        flag = true;
                        break OUTER;
                    }
                    if(map[nr][nc] == '#' || map[nr][nc] == 'F')  continue;
                    map[nr][nc] = '#';
                    road.offer(new Point(nr, nc));
                }
            }
            time++;
        }
        if(flag) System.out.println(time);
        else System.out.println("IMPOSSIBLE");

    }
}
