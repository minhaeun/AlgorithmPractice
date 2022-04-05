package SWEA.SWEA5656;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5656 {
    static int N, W, H;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static class brick{
        int r, c, scope;
        public brick(int r, int c, int scope){
            this.r = r;
            this.c = c;
            this.scope = scope;
        }
    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/SWEA/SWEA5656/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            for(int r = 0; r < H; r++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int c = 0; c < W; c++){
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            /*
            중복 순열로 벽돌 떨어트릴 위치 정하기
            중복 순열로 벽돌을 제거한 다음 나오는 최댓값 갱신
            연쇄반응으로 벽돌이 제거되기 떄문에 dfs 로 벽돌 계속 제거
            다 제거한 후 빈 공간이 있으면(0) 밑으로 벽돌 내려주기(큐에 넣어주자! 0 제외하고 )
            남은 벽돌의 개수 구하기(map에서 0보다 큰 수 갯수 세기)
             */

            sb.append("#").append(tc).append(" ").append(0).append("\n");
        }


    }
}
