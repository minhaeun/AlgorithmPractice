package baekjoon.boj3109;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3109 {
    static int R, C, ans;
    static char[][] map;
    static int[] dr = {-1, 0, 1};   // 우상, 우, 우하
    static int[] dc = {1, 1, 1};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj3109/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][];

        for(int i = 0; i < R; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < R; i++){
            ans += setPipe(i, 0);
        }
        System.out.println(ans);

    }
    public static int setPipe(int r, int c){
        map[r][c] = 'x';
        if(c == C - 1)  return 1;

        for(int d = 0; d < 3; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr < 0 || nr >= R || nc < 0 || nc >= C)  continue;
            if(map[nr][nc] == 'x')  continue;
            // 지금 현재 경로가 한번 갔던 경로라면 또 가볼 필요 없으니까 return
            if(setPipe(nr, nc) == 1) return 1;
        }
        return 0;
    }


}
