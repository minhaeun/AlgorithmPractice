package baekjoon.simulation.boj16918;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16918 {
    static int R, C, N;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};
    static int[][] timeMap;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/simulation/boj16918/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[R][];
        timeMap = new int[R][C];    // 각각 자리에서 폭탄이 터지는 시간 저장

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    timeMap[i][j] = 3;  // 폭탄 놓으면 3초 뒤 터짐
                }
            }
        }
        int time = 0;

        while (time++ < N) {   // 시간이 N까지
            if (time % 2 == 0) {  // 비어있는 칸에 폭탄 설치
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            timeMap[i][j] = time + 3;
                        }
                    }
                }
            } else {  // 시간 다 된 폭탄 터짐
                for (int r = 0; r < R; r++) {
                    for (int c = 0; c < C; c++) {
                        if (timeMap[r][c] == time) {  // 현재 시간과 같은 폭탄이 있으면 폭탄 폭발
                            map[r][c] = '.';
                            for (int d = 0; d < 4; d++) { // 폭탄 기준으로 상하좌우 터짐
                                int nr = r + dr[d];
                                int nc = c + dc[d];

                                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;   // 범위 체크
                                if (map[nr][nc] == '.') continue;
                                map[nr][nc] = '.';  // 폭탄이 터지면서 .으로 바꿔줌
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
