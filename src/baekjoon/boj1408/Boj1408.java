package baekjoon.boj1408;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1408 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1408/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int now = 0;
        int start = 0;

        now = (h * 3600) + (m * 60) + s;

        st = new StringTokenizer(br.readLine(), ":");
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        start = (h * 3600) + (m * 60) + s;

        int time = 0;

        if(start > now) time = start - now;
        else time = (24 * 3600) - (now - start);

        System.out.format("%02d:%02d:%02d", (time / 3600), ((time / 60) % 60), (time % 60));





    }
}
