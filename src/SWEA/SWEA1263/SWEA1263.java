package SWEA.SWEA1263;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1263 {
    static int N;
    static int[][] adj;
    static final int INF = 999;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/SWEA/SWEA1263/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            adj = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    adj[i][j] = Integer.parseInt(st.nextToken());
                    if (adj[i][j] == 0 && i != j) {
                        adj[i][j] = INF;
                    }
                }
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                int value = 0;
                for (int j = 1; j <= N; j++) {
                    value += adj[i][j];
                }
                min = Math.min(value, min);
            }

            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());
    }
}
