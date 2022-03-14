package baekjoon.graph.boj17070;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17070 {
    static int N;
    static int[][] map;
    static int count;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/graph/boj17070/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 파이프 밀기
        push(0, 1, 0);  // 0 : 가로, 1 : 우하, 2: 세로
        System.out.println(count);

    }

    public static void push(int r, int c, int state) {
        if (r == N - 1 && c == N - 1) {    // 최종 지점까지 왔으면
            count++;
            return;
        }
        // 파이프가 가로로 가려면 현재 가로이거나 우하 상태
        if (state != 2) {
            if (c + 1 < N && map[r][c + 1] == 0) {  // 가로의 범위를 넘지 않고, 벽이 아니면
                push(r, c + 1, 0);
            }
        }

        // 파이프가 세로로 가려면 현재 세로이거나 우하 상태
        if (state != 0) {
            if (r + 1 < N && map[r + 1][c] == 0) {
                push(r + 1, c, 2);
            }
        }

        // 파이프가 우하로 가려면 어떤 상태든 가능
        if (r + 1 < N && c + 1 < N && map[r + 1][c] == 0 && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0) {
            push(r + 1, c + 1, 1);
        }
    }

}
