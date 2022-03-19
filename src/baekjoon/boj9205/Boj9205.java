package baekjoon.boj9205;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOError;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj9205 {
    static int t, n, house_x, house_y, party_x, party_y;
    static ArrayList<Point> arrayList;

    public static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj9205/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            boolean flag = false;
            n = Integer.parseInt(br.readLine());
            arrayList = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    house_x = x;
                    house_y = y;
                } else if (i == n + 1) {
                    party_x = x;
                    party_y = y;
                } else {
                    arrayList.add(new Point(x, y));
                }
            }
            Queue<Point> queue = new LinkedList<>();
            boolean[] visit = new boolean[n];
            queue.add(new Point(house_x, house_y));
            while (!queue.isEmpty()) {
                Point cur = queue.poll();
                int cx = cur.x, cy = cur.y;
                if (Math.abs(cx - party_x) + Math.abs(cy - party_y) <= 1000) {
                    sb.append("happy").append("\n");
                    flag = true;
                    break;
                }
                for (int i = 0; i < n; i++) {
                    if (!visit[i]) {
                        int nx = arrayList.get(i).x, ny = arrayList.get(i).y;
                        int dist = Math.abs(cx - nx) + Math.abs(cy - ny);
                        if (dist <= 1000) {
                            visit[i] = true;
                            queue.add(new Point(nx, ny));
                        }
                    }
                }
            }
            if(!flag)
                sb.append("sad").append("\n");
        }
        System.out.println(sb.toString());
    }

}
