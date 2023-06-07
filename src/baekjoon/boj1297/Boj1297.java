package baekjoon.boj1297;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1297 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1297/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");



        int d = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        double res = Math.sqrt(Math.pow(d, 2) / (Math.pow(h, 2) + Math.pow(w, 2)));
        System.out.print((int)Math.floor(res * h) + " ");
        System.out.println((int)Math.floor(res * w));


    }
}
