package baekjoon.graph.boj4963;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj4963 {
    public static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    public static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    public static int[][] map;
    public static class Node{
        int r, c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }

    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj4963/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0)    break;

            map = new int[h + 1][w + 1];

            for(int i = 1; i < h + 1; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 1; j < w + 1; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            int count = 0;
            Queue<Node> queue = new LinkedList<>();
            for(int r = 1; r < h + 1; r++){
                for(int c = 1; c < w + 1; c++){
                    if(map[r][c] == 0) continue;
                    queue.offer(new Node(r, c));
                    int nr = 0, nc = 0;
                    while(!queue.isEmpty()){
                        Node now = queue.poll();
                        for(int d = 0; d < 8; d++) {
                            nr = now.r + dr[d];
                            nc = now.c + dc[d];
                            if (nr < 1 || nc < 1 || nr >= h + 1 || nc >= w + 1 || map[nr][nc] == 0)
                                continue;
                            map[nr][nc] = 0;
                            queue.offer(new Node(nr, nc));
                        }
                    }
                    count++;

                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
