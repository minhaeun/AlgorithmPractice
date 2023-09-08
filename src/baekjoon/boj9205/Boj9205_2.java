package baekjoon.boj9205;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj9205_2 {
    public static ArrayList<Point> convs;
    public static class Point{
        int x, y;
        boolean visited;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
            this.visited = false;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj9205/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Point home = null, festival = null;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            convs = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            home = new Point(x, y);
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                convs.add(new Point(x, y));
            }
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            festival = new Point(x, y);

            Queue<Point> queue = new LinkedList<>();
            queue.offer(home);
            boolean flag = false;
            while(!queue.isEmpty()){
                Point now = queue.poll();
                if(calDis(now, festival) > 1000){
                    for(Point next : convs){
                        if(calDis(now, next) > 1000 || next.visited)    continue;
                        next.visited = true;
                        queue.offer(next);
                    }
                }else{
                    // 페스티벌 도착
                    sb.append("happy\n");
                    flag = true;
                    break;
                }
            }
            if(!flag)   sb.append("sad\n");
        }
        System.out.println(sb);
    }
    public static int calDis(Point start, Point end){
        return Math.abs(start.x - end.x) + Math.abs(start.y - end.y);
    }
    public static Point searchConv(Point now){
        int min = Integer.MAX_VALUE;
        Point minConv = null;
        for(Point point : convs){
            if(point.visited)   continue;
            int dis = calDis(now, point);
            if(min > dis){
                min = dis;
                minConv = point;
            }
        }
        return minConv;
    }
}
