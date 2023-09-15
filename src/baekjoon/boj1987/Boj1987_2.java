package baekjoon.boj1987;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1987_2 {
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static int R, C, max = 0;
    public static boolean[] alpha;
    public static char[][] map;
    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1987/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpha = new boolean[26];
        map = new char[R][];

        for(int i = 0; i < R; i++){
            map[i] = br.readLine().toCharArray();
        }

        alpha[map[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(max);

    }
    public static void dfs(int r, int c, int count){
        if(max < count) max = count;
        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= R || nc < 0 || nc >= C || alpha[map[nr][nc] - 'A'])  continue;
            alpha[map[nr][nc] - 'A'] = true;
            dfs(nr, nc, count + 1);
            alpha[map[nr][nc] - 'A'] = false;
        }
    }
}
