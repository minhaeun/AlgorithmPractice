package baekjoon.graph.boj3184;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3184_2 {
    public static int R, C, sheepCount, wolfCount, sheep, wolf;
    public static char map[][];
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
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj3184/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][];

        for(int i = 0; i < R; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == '#')    continue;
                sheep = wolf = 0;
                dfs(i, j);
                if(sheep > wolf)  sheepCount += sheep ;
                else wolfCount += wolf;
            }
        }

        sb.append(sheepCount).append(" ").append(wolfCount);
        System.out.println(sb);

    }

    public static void dfs(int r, int c){

        if(map[r][c] == 'o')    sheep++;
        else if(map[r][c] == 'v')   wolf++;
        map[r][c] = '#';

        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '#')    continue;
            dfs(nr, nc);

        }

    }
}
