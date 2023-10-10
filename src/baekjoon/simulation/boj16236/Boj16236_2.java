package baekjoon.simulation.boj16236;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj16236_2 {
    public static int N, map[][], time = 0, count = 0;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static Shark shark;
    public static ArrayList<Point> fishList;
    public static boolean visited[][];
    public static class Shark{
        int r, c, size;
        public Shark(int r, int c){
            this.r = r;
            this.c = c;
            this.size = 2;
        }
    }
    public static class Point{
        int r, c, dist;
        public Point(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/simulation/boj16236/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    shark = new Shark(i, j);
                    map[i][j] = 0;
                }
            }
        }

        while(true){
            bfs(shark.r, shark.c);
            if(fishList.isEmpty())  break;

            Collections.sort(fishList, new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if(o1.dist == o2.dist){
                        if(o1.r == o2.r)    return o1.c - o2.c;
                        return o1.r - o2.r;
                    }
                    return o1.dist - o2.dist;
                }
            });

            Point eatPoint = fishList.get(0);

            shark.r = eatPoint.r;
            shark.c = eatPoint.c;
            count++;
            time += eatPoint.dist;
            if(count == shark.size){
                shark.size++;
                count = 0;
            }
            map[eatPoint.r][eatPoint.c] = 0;
        }
        System.out.println(time);


    }

    public static void bfs(int i, int j){
        Queue<Point> queue = new LinkedList<>();
        fishList = new ArrayList<>();
        queue.offer(new Point(i, j, 0));
        visited = new boolean[N][N];
        visited[i][j] = true;

        while(!queue.isEmpty()){
            Point now = queue.poll();
            int r = now.r;
            int c = now.c;
            int size = shark.size;
            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] > size) continue;
                visited[nr][nc] = true;
                queue.offer(new Point(nr, nc, now.dist + 1));
                if(map[nr][nc] < size && map[nr][nc] != 0)  fishList.add(new Point(nr, nc, now.dist + 1));
            }
        }
    }
}
