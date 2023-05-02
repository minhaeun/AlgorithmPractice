package baekjoon.boj3187;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3187 {
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static int R, C, sheep, wolf;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj3187/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++){
            map[i] = br.readLine().toCharArray();
        }
        int sheep_total = 0, wolf_total = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(visited[i][j] || map[i][j] == '#')   continue;
                sheep = 0;
                wolf = 0;
                dfs(i, j);
                if(sheep > wolf)    sheep_total += sheep;
                else wolf_total += wolf;
            }
        }
        System.out.println(sheep_total + " " + wolf_total);
    }
    public static void dfs(int r, int c){
        if('k' == map[r][c])    sheep++;
        else if('v' == map[r][c])   wolf++;
        visited[r][c] = true;

        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] || map[nr][nc] == '#') continue;
            dfs(nr, nc);
        }
    }

}
