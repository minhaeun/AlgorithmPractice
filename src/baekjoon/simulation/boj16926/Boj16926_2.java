package baekjoon.simulation.boj16926;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16926_2 {
    public static int N, M, R, map[][];
    public static int dr[] = {0, 1, 0, -1}; // 우, 하, 좌, 상
    public static int dc[] = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/simulation/boj16926/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < R; k++) {
            int num = Math.min(N, M) / 2;

            for(int n = 0; n < num; n++){
                int r = n;
                int c = n;
                int tmp = map[r][c];
                for(int d = 0; d < 4; d++){
                    while(true){
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        if(nr < n || nr >= N - n || nc < n || nc >= M - n)  break;
                        map[r][c] = map[nr][nc];
                        r = nr;
                        c = nc;
                    }
                }
                map[n + 1][n] = tmp;
            }
        }
        for(int[] row : map){
            for(int value : row){
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
