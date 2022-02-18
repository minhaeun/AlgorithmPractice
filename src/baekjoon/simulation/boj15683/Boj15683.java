package baekjoon.simulation.boj15683;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj15683 {

    static int N, M;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};   // 상, 우, 하,
    static int[] dc = {0, 1, 0, -1};
    static ArrayList<CCTV> cctvs;
    static int size;    // cctv 총 개수
    static int min = Integer.MAX_VALUE;

    public static class CCTV {
        int r, c, opt;  // 카메라 위치(r, c), 카메라 번호(opt)
        int[] dd;

        public CCTV(int r, int c, int opt) {
            this.r = r;
            this.c = c;
            this.opt = opt;

            if (opt == 1) {     // 1방향
                this.dd = new int[1];
                dd[0] = 0;
            } else if (opt == 2) {     // 2방향인데 반대방향
                this.dd = new int[2];
                dd[0] = 0;
                dd[1] = 2;
            } else if (opt == 3) {      // 2방향인데 90도
                this.dd = new int[2];
                dd[0] = 0;
                dd[1] = 1;
            } else if (opt == 4) {      // 3방향
                this.dd = new int[3];
                dd[0] = 0;
                dd[1] = 1;
                dd[2] = 2;
            } else if (opt == 5) {      // 4방향
                this.dd = new int[4];
                dd[0] = 0;
                dd[1] = 1;
                dd[2] = 2;
                dd[3] = 3;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/simulation/boj15683/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cctvs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] < 6) cctvs.add(new CCTV(i, j, map[i][j]));   // 1-5번이면 cctv list에 추가
            }
        }
        size = cctvs.size();
        dfs(0);
        System.out.println(min);

    }

    public static void dfs(int count) {
        // cctv 갯수만큼 방향이 다 정해진 경우
        if (count == size) {
            // tmp배열에 map 복사 후
            int[][] tmp = new int[N][M];
            for(int i = 0; i < N; i++){
                tmp[i] = map[i].clone();
            }
            // 방향별로 확인
            for (int i = 0; i < size; i++) {
                CCTV cctv = cctvs.get(i);
                int dir;
                for (int j = 0; j < cctv.dd.length; j++) {
                    dir = cctv.dd[j];
                    int nr = cctv.r;
                    int nc = cctv.c;
                    while (true) {
                        nr += dr[dir];
                        nc += dc[dir];
                        if (nr < 0 || nr >= N || nc < 0 || nc >= M) break;
                        if (tmp[nr][nc] == 6) break;    // 벽이니까 바로 break
                        if (map[nr][nc] == 0) {     // 0이면 7로 바꾸고 감시 완료 표시
                            tmp[nr][nc] = 7;
                        }
                    }
                }
            }

            int sum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (tmp[i][j] == 0) sum++;      // 감시할 수 없는 부분(0) 개수 세기
                }
            }
            min = Math.min(min, sum);

        } else {
            CCTV cctv = cctvs.get(count);
            int[] dir = cctv.dd;
            // cctv가 1, 3, 4인 경우에는 4방향 고려
            if (cctv.opt == 1 || cctv.opt == 3 || cctv.opt == 4) {
                for (int d = 0; d < 4; d++) {
                    // class에 미리 저장해뒀던 방향만큼
                    // 1 - 1방향
                    // 3 - 2방향
                    // 4 - 3방향
                    for (int i = 0; i < cctv.dd.length; i++) {
                        cctv.dd[i] += d;
                        cctv.dd[i] = cctv.dd[i] % 4;
                    }
                    dfs(count + 1);
                    cctv.dd = dir;
                }
            }
            // cctv가 2인 경우에는 2방향 고려
            else if (cctv.opt == 2) {
                for (int d = 0; d < 2; d++) {
                    for (int i = 0; i < cctv.dd.length; i++) {
                        cctv.dd[i] += d;
                        cctv.dd[i] = cctv.dd[i] % 4;
                    }
                    dfs(count + 1);
                    cctv.dd = dir;
                }
            }
            // cctv가 5인 경우에는 모든 방향 고려해야하니까 갯수먄 늘려주고 dfs 실행
            else if (cctv.opt == 5) {
                dfs(count + 1);
            }
        }
    }


}
