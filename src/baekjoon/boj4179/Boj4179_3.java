package baekjoon.boj4179;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj4179_3 {
    public static Point jihoon;
    public static ArrayList<Point> fireList;
    public static int R, C, visited[][], answer = -1;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static char[][] map;
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new int[R][C];
        for(int i = 0; i < R; i++){
            Arrays.fill(visited[i], -1);
        }

        fireList = new ArrayList<Point>();

        for(int i = 0 ; i < R ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < C ; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'J'){
                    map[i][j] = '.';
                    jihoon = new Point(i, j);
                }
                else if(map[i][j] == 'F') fireList.add(new Point(i, j));
            }
        }

        Queue<Point> jQueue = new LinkedList<Point>();
        Queue<Point> fQueue = new LinkedList<Point>();
        jQueue.offer(jihoon);
        visited[jihoon.r][jihoon.c] = 0;

        int fireLen = fireList.size();
        for(int i = 0; i < fireLen; i++){
            fQueue.offer(fireList.get(i));
        }

        OUTER : while(!jQueue.isEmpty()){
            int fLen = fQueue.size();
            for(int i = 0; i < fLen; i++){
                Point now = fQueue.poll();
                int r = now.r;
                int c = now.c;
                for(int d = 0; d < 4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc] == 'F' || map[nr][nc] == '#') continue;
                    map[nr][nc] = 'F';
                    fQueue.offer(new Point(nr, nc));
                }
            }
            int jLen = jQueue.size();
            for(int i = 0; i < jLen; i++){
                Point now = jQueue.poll();
                int r = now.r;
                int c = now.c;
                for(int d = 0; d < 4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nc < 0 || nr >= R || nc >= C){
                        answer = visited[r][c] + 1;
                        break OUTER;
                    }
                    if(map[nr][nc] == '#' || map[nr][nc] == 'F' || visited[nr][nc] != -1) continue;
                    visited[nr][nc] = visited[r][c] + 1;
                    jihoon = new Point(nr, nc);
                    jQueue.offer(jihoon);
                }
            }
        }
        if(answer == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(answer);
    }
}
