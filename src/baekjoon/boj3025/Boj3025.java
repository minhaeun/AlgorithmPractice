package baekjoon.boj3025;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3025 {
    static int R, C;
    static char[][] map;
    static int N;   // 돌을 던진 횟수
    static int[] columns;   // 돌 던질 열의 위치

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj3025/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][];


        // map 입력
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        N = Integer.parseInt(br.readLine());
        columns = new int[N];
        for (int i = 0; i < N; i++) {
            // (0,0) 부터 시작하려고 -1
            columns[i] = Integer.parseInt(br.readLine()) - 1;
        }


        // 돌 던지기 시작   : 열 개수 만큼
        for (int column : columns) {
            int r = 0;
            int c = column;
            while (true) {            // --  map[0][c] 부터 r + 1  하면서 탐색 (아래로 탐색)
                int nr = r + 1;
                int nc = c;
                int left = nc - 1;
                int right = nc + 1;

                // 제일 밑 이거나 X가 있으면
                if (nr == R || map[nr][nc] == 'X') {
                    map[r][c] = 'O';
                    break;
                }

                // 다음 칸에 돌이 있으면
                if (isRock(nr, nc)) {
                    // 그 돌의 왼쪽 - 아래 확인
                    if (left >= 0 && map[r][left] == '.' && map[nr][left] == '.') {
                        c = left;
                    }else if(right >= 0 && map[r][right] == '.' && map[nr][right] == '.'){
                        c = right;
                    }else{  // 왼쪽, 오른ㅁ쪽 다 안비었으면
                        map[r][c] = 'O';
                        break;
                    }

                }
                r++;
            }

        }
        int rlen = map.length;
        int clen = map[0].length;
        for (int i = 0; i < rlen; i++) {
            for (int j = 0; j < clen; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }


    }

    // 돌이 있는지 확인하는 함수
    public static boolean isRock(int r, int c) {
        return map[r][c] == 'O';
    }

    // 장애물이 있는지 확인하는 함수
    public static boolean isObstacle(int r, int c) {
        return map[r][c] == 'X';
    }

    // 범위 넘어갔는지 확인하는 함수
    public static boolean isOverBound(int r, int c) {
        if (r < 0 || r >= R || c < 0 || c >= C) return true;
        return false;
    }
}
