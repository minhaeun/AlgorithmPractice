package baekjoon.graph.boj2667;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Boj2667 {
    static int N, count;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/graph/boj2667/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new char[N][];

        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] != '1')    continue;
                count = 0;
                dfs(i, j);
                arrayList.add(count);
            }
        }

        Collections.sort(arrayList);
        sb.append(arrayList.size()).append("\n");
        for(int value : arrayList){
            sb.append(value).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    public static void dfs(int r, int c){
        count++;
        map[r][c] = '0';

        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= N || nc < 0 || nc >= N)  continue;
            if(map[nr][nc] != '1')  continue;
            dfs(nr, nc);
        }
    }
}
