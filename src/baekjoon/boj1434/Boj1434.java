package baekjoon.boj1434;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1434 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1434/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int sum_box = 0;
        int sum_book = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            int box = Integer.parseInt(st.nextToken());
            sum_box += box;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            int book = Integer.parseInt(st.nextToken());
            sum_book += book;
        }
        System.out.println(sum_box - sum_book);
    }
}
