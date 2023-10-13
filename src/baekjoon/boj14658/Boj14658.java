package baekjoon.boj14658;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj14658 {
    public static int N, M, L, K;
    public static ArrayList<Point> stars;
    public static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj14658/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        stars = new ArrayList<>();

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            stars.add(new Point(r, c));
        }

        int max = Integer.MIN_VALUE;
        for(Point point1 : stars){
            for(Point point2 : stars){
                max = Math.max(max, boundStar(point1.r, point2.c));
            }
        }
        System.out.println(K - max);
    }
    public static int boundStar(int r, int c){
        int res = 0;
        for(Point point : stars){
            if(r <= point.r && point.r <= r + L && c <= point.c && point.c <= c + L)    res++;
        }
        return res;
    }
}
