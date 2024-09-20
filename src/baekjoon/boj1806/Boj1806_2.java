package baekjoon.boj1806;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1806_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1806/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        long min = Integer.MAX_VALUE;
        long sum = 0;
        while(start <= N && end <= N){
            if(sum < S){
                sum += arr[end];
                end++;
            }
            else{
                min = Math.min(min, end - start);
                sum -= arr[start];
                start++;
            }
        }
        if(min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);

    }
}
