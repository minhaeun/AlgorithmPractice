package baekjoon.boj2210;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj2210 {
    public static int[][] map;
    public static HashSet<String> list;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2210/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5];
        list = new HashSet<>();

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String s = "";
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                dfs(i, j, 0, s);
            }
        }

        System.out.println(list.size());
    }

    public static void dfs(int r, int c, int count, String s){
        if(count == 6){
            list.add(s);
            return;
        }
        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5)  continue;
            dfs(nr, nc, count + 1, s + map[r][c]);
        }
    }
}
