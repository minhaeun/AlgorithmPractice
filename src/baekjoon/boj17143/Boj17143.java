package baekjoon.boj17143;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj17143 {
    static int R, C, M, total;
    static Shark[][] grid;
    static ArrayList<Shark> sharks;
    static int[] dr = {0, -1, 1, 0, 0};  // 상, 하, 우, 좌
    static int[] dc = {0, 0, 0, 1, -1};

    public static class Shark {
        int r, c, s, d, z;
        public Shark(int r, int c, int s, int d, int z){
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj17143/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sharks = new ArrayList<>();
        grid = new Shark[R + 1][C + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            grid[r][c] = new Shark(r, c, s, d, z);
            sharks.add(grid[r][c]);
        }

        for(int i = 1; i <= C; i++){
            // 상어잡기
            catchShark(i);
            // 상어 움직이기
            move();
        }
        System.out.println(total);
    }

    public static void catchShark(int j){
        for(int i = 1; i <= R; i++){
            if(grid[i][j] != null){
                total += grid[i][j].z;
                sharks.remove(grid[i][j]);
                grid[i][j] = null;
                break;
            }
        }
    }

    public static void move(){
        if(sharks.size() > 0){
            for(int i = 0; i < sharks.size(); i++){
                Shark shark = sharks.get(i);
                int r = shark.r;
                int c = shark.c;
                int d = shark.d;
                int s = shark.s;

                while(s > 0){
                    r += dr[d];
                    c += dc[d];

                    if(r < 1 || r > R || c < 1 || c > C){
                        r -= dr[d];
                        c -= dc[d];

                        if(d == 1) d = 2;
                        else if(d == 2) d = 1;
                        else if(d == 3) d = 4;
                        else if(d == 4) d = 3;

                        continue;
                    }
                    s--;

                }
                shark.r = r;
                shark.c = c;
                shark.d = d;
            }

            grid = new Shark[R + 1][C + 1];
            for(int i = 0; i < sharks.size(); i++){
                int r = sharks.get(i).r;
                int c = sharks.get(i).c;

                if(grid[r][c] == null)  grid[r][c] = sharks.get(i);
                else grid[r][c] = grid[r][c].z > sharks.get(i).z ? grid[r][c] : sharks.get(i);
            }

            sharks.clear();
            for(int r = 1; r<=R; r++){
                for(int c = 1; c <= C; c++){
                    if(grid[r][c] != null) sharks.add(grid[r][c]);
                }
            }
        }

    }
}
