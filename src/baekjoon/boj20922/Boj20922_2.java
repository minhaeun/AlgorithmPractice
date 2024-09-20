package baekjoon.boj20922;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20922_2 {
    public static int N, K, arr[], check[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj20922/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        check = new int[100001];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int max = 0;
        while(end < N){
            int value = arr[end];
            if(check[value] < K){
                check[value]++;
                end++;
            }else{
                max = Math.max(max, end - start);
                int num = arr[start];
                check[num]--;
                start++;
            }
        }
        System.out.println(max);

    }
}
