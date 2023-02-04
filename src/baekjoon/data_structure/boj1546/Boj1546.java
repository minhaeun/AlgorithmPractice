package baekjoon.data_structure.boj1546;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1546 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj1546/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        double sum = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        for(int i = 0; i < N; i++){
            sum += (double) arr[i] / max * 100;
        }

        System.out.println(sum / N);

    }
}
