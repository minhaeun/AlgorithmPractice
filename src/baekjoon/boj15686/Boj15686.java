package baekjoon.boj15686;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj15686 {
    public static int N, M, map[][], totalMin = Integer.MAX_VALUE;
    public static boolean visited[];
    public static ArrayList<Point> chicken, house;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static class Point{
        int r, c, dis = Integer.MAX_VALUE;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
        public int cal(int r, int c){
           return Math.abs(this.r - r) + Math.abs(this.c - c);
        }
        public int getDis(){
            return this.dis;
        }
        public void setDis(int dis){
            this.dis = dis;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj15686/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();


        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)  house.add(new Point(i, j));
                else if(map[i][j] == 2) chicken.add(new Point(i, j));
            }
        }
        visited = new boolean[chicken.size()];
        select(0, 0);

        System.out.println(totalMin);
    }

    public static void select(int start, int count){
        if(count == M){
            // M개의 치킨집으로 치킨거리 계산
            totalMin = Math.min(calDis(), totalMin);
            return;
        }

        for(int i = start; i < chicken.size(); i++){
            if(visited[i])  continue;
            visited[i] = true;
            select(i + 1, count + 1);
            visited[i] = false;
        }
    }

    public static int calDis(){
        clearDis();
        for(int i = 0; i < chicken.size(); i++){
            if(!visited[i])  continue;
            int r = chicken.get(i).r;
            int c = chicken.get(i).c;
            for(int j = 0; j < house.size(); j++){
                // 치킨거리 계산
                if(house.get(j).getDis() == 1)   continue;
                int dis = house.get(j).getDis();
                int tmp = house.get(j).cal(r, c);
                int min = Math.min(dis, tmp);
                house.get(j).setDis(min);
            }
        }

        int sum = 0;
        for(Point value : house){
            sum += value.getDis();
        }
        return sum;
    }

    public static void clearDis(){
        for(Point value : house){
            value.setDis(Integer.MAX_VALUE);
        }
    }
}
