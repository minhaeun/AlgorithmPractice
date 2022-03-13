package baekjoon.boj15666;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15666 {
    static int N, M, numbers[], input[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj15666/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        numbers = new int[M];
        input = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        permutation(0, 1);
        System.out.println(sb);

    }
    public static void permutation(int count, int start){
        if(count == M){
            for(int value : numbers){
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i <= N; i++){
            if(input[i-1] == input[i])  continue;
            numbers[count] = input[i];
            permutation(count + 1, i);
        }
    }
}
