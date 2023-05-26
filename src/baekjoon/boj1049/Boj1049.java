package baekjoon.boj1049;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1049 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1049/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;

        int[] unit = new int[M];
        int[] pack = new int[M];


        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            pack[i] = Integer.parseInt(st.nextToken());
            unit[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(unit);
        Arrays.sort(pack);

        min = Math.min(((N / 6) + 1) * pack[0], N * unit[0]);
        min = Math.min(min, ((N / 6)) * pack[0] + (N % 6) * unit[0]);

        System.out.println(min);

    }
}
