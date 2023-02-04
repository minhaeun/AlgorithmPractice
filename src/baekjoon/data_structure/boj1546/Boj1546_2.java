package baekjoon.data_structure.boj1546;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1546_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj1546/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        long sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(st.nextToken());
            if(max < value) max = value;
            sum += value;
        }

        System.out.println(sum * 100.0 / max / N);


    }
}
