package baekjoon.simulation.boj19236;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj19236 {
    public static int max = Integer.MIN_VALUE;
    public static int[][] map;
    public static Fish[] fishes;
    public static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 상, 좌상, 좌, 좌하, 하, 우하, 우, 우상
    public static int[] dc = { 0, -1, -1, -1, 0, 1, 1, 1 };

    public static class Fish {
        int num, r, c, dir, alive;

        Fish(int num, int r, int c, int dir, int alive) {
            this.num = num;
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.alive = alive;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/simulation/boj19236/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[4][4];
        fishes = new Fish[17];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                fishes[num] = new Fish(num, i, j, dir, 1);
                map[i][j] = num;
            }
        }

        int sr = 0, sc = 0;
        int sdir = fishes[map[0][0]].dir;
        int eat = map[0][0];
        fishes[map[0][0]].alive = 0;
        map[0][0] = -1;

        dfs(sr, sc, sdir, eat);

        System.out.println(max);

    }

    public static void dfs(int sr, int sc, int sdir, int eat) {
        max = Math.max(max, eat);

        int[][] tmpMap = new int[map.length][map.length];
        for (int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, tmpMap[i], 0, map.length);
        }

        Fish[] tmpFishes = new Fish[fishes.length];
        for (int i = 1; i <= 16; i++) {
            tmpFishes[i] = new Fish(fishes[i].num, fishes[i].r, fishes[i].c, fishes[i].dir, fishes[i].alive);
        }

        moveFish();

        for(int i = 1; i < 4; i++) {
            int nr = sr + dr[sdir] * i;
            int nc = sc + dc[sdir] * i;

            if(nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || map[nr][nc] == 0)	continue;
            int eatFish = map[nr][nc];
            int ndir = fishes[eatFish].dir;
            map[sr][sc] = 0;
            map[nr][nc] = -1;
            fishes[eatFish].alive = 0;

            dfs(nr, nc, ndir, eat + eatFish);

            fishes[eatFish].alive = 1;
            map[sr][sc] = -1;
            map[nr][nc] = eatFish;
        }

        for(int j = 0; j < map.length; j++) {
            System.arraycopy(tmpMap[j], 0, map[j], 0, map.length);
        }
        for(int i = 1; i <= 16; i++) {
            fishes[i] = new Fish(tmpFishes[i].num, tmpFishes[i].r, tmpFishes[i].c, tmpFishes[i].dir, tmpFishes[i].alive);
        }


    }

    public static void moveFish() {
        for (int i = 1; i < 17; i++) {
            if (fishes[i].alive == 0)
                continue;
            int cnt = 0;
            int dir = fishes[i].dir;
            int nr = 0, nc = 0;

            while (cnt < 8) {
                dir %= 8;
                fishes[i].dir = dir;

                nr = fishes[i].r + dr[dir];
                nc = fishes[i].c + dc[dir];

                if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || map[nr][nc] == -1) {
                    dir++;
                    cnt++;
                } else {
                    if (map[nr][nc] == 0) {
                        map[fishes[i].r][fishes[i].c] = 0;
                        fishes[i].r = nr;
                        fishes[i].c = nc;
                        map[nr][nc] = i;
                    } else {
                        int changeFish = fishes[map[nr][nc]].num;
                        fishes[changeFish].r = fishes[i].r;
                        fishes[changeFish].c = fishes[i].c;
                        map[fishes[changeFish].r][fishes[changeFish].c] = changeFish;
                        fishes[i].r = nr;
                        fishes[i].c = nc;
                        map[nr][nc] = i;
                    }
                    break;
                }

            }
        }
    }

}
