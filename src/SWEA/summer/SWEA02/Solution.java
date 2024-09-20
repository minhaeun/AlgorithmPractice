package SWEA.summer.SWEA02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static int N, M, Q, map[][];
    public static boolean visited[][];
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/SWEA/summer/SWEA02/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            Q = Integer.parseInt(st.nextToken());
            int ans = 0;
            map = new int[N + 1][M + 1];
            for(int i = 1; i < N + 1; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 1; j < M + 1; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int q = 0; q < Q; q++){
                st = new StringTokenizer(br.readLine(), " ");
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                visited = new boolean[N + 1][M + 1];
                map[r][c] = x;
                for(int i = 1; i < N + 1; i++){
                    for(int j = 1; j < M + 1; j++){
                        if(visited[i][j])   continue;
                        if(check(i, j)) {
                            ans++;
                            break;
                        }

                    }
                }
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
    public static boolean check(int r, int c){
        boolean[][] tmp = new boolean[N + 1][M + 1];
        for(int i = 0; i < N + 1; i++){
            tmp[i] = visited[i].clone();
        }
        // r check
        for(int i = 1; i < N + 1; i++){
            if(i == r)  continue;
            tmp[i][c] = true;
            if(map[i][c] > map[r][c])   return false;
        }
        // c check
        for(int i = 1; i < M + 1; i++){
            if(i == c)  continue;
            tmp[r][i] = true;
            if(map[r][i] > map[r][c])   return false;
        }
        for(int i = 0; i < N + 1; i++){
            visited[i] = tmp[i].clone();
        }
        visited[r][c] = true;
        return true;
    }

}
