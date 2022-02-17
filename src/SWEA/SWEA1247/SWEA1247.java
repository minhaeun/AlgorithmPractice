package SWEA.SWEA1247;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1247 {
    static int N;
    static int numbers[];
    static boolean[] isSelected;
    static int num, min;
    static Point[] points;
    public static class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/SWEA/SWEA1247/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            isSelected = new boolean[N + 1];
            numbers = new int[N];
            min = Integer.MAX_VALUE; num = 0;
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine(), " ");
            points = new Point[N + 2];
            Point company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point house = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));


            for(int i = 1; i <= N; i++){
                points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            points[0] = company;
            points[N + 1] = house;

            permutation(0);
            sb.append("#").append(tc).append(" ").append(min);
            System.out.println(sb);
      }

    }

    public static void permutation(int cnt){
        num = 0;
        if(cnt == N){
            // 거리 계산 하기
            int dist = 0;
            for(int i = 0; i < N -1; i++){
                dist += getDist(numbers[i], numbers[i + 1]);
            }

            dist += getDist(0, numbers[0]) + getDist(numbers[N-1], N + 1);

            min = Math.min(dist, min);
            return;
        }

        for(int i = 1; i <= N; i++){
            if(isSelected[i] == true)   continue;

            numbers[cnt] = i;
            isSelected[i] = true;

            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }

    public static int getDist(int p1, int p2){
        return Math.abs(points[p1].x - points[p2].x) + Math.abs(points[p1].y - points[p2].y);
    }
}
