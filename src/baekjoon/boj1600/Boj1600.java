package baekjoon.boj1600;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1600 {
    static int K, W, H;
    static int[][] grid;
    static int[][] visit;
    static int[] dr = {-1, 1, 0, 0, -2, -2, 2, 2, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1, -2, 2, -2, 2};
    static class Monkey{
        int r, c, k;
        Monkey(int r, int c, int k){
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1600/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        grid = new int[H][W];
        visit = new int[H][W];

        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < W; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = -1;
            }
        }

        Queue<Monkey> queue = new LinkedList<>();
        queue.add(new Monkey(0, 0, K));
        visit[0][0] = 0;

        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-- > 0){
                Monkey monkey = queue.poll();

                if(monkey.r == H - 1 && monkey.c == W - 1){
                    System.out.println(count);
                    return;
                }

                if(visit[monkey.r][monkey.c] >= monkey.k)    continue;
                visit[monkey.r][monkey.c] = monkey.k;

                for(int d = 0; d < 4; d++){
                    int nr = monkey.r + dr[d];
                    int nc = monkey.c + dc[d];

                    if(nr < 0 || nr >= H || nc < 0 || nc >= W)  continue;

                    if(grid[nr][nc] == 1 || visit[nr][nc] == monkey.k)   continue;

                    queue.add(new Monkey(nr, nc, monkey.k));
                }

                if(monkey.k > 0){
                    for(int d = 4; d < 12; d++){
                        int nr = monkey.r + dr[d];
                        int nc = monkey.c + dc[d];

                        if(nr < 0 || nr >= H || nc < 0 || nc >= W)  continue;

                        if(grid[nr][nc] == 1 || visit[nr][nc] == monkey.k - 1)   continue;

                        queue.add(new Monkey(nr, nc, monkey.k - 1));
                    }
                }
            }
            count++;

        }

        System.out.println(-1);
    }
}
