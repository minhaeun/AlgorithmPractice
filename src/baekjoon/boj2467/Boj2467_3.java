package baekjoon.boj2467;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2467_3 {
    public static int N, arr[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2467/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = N - 1, a = 0, b = 0;
        int ans = 2000000001;
        while(low < high){
            int sum = arr[low] + arr[high];
            if(Math.abs(sum) <= Math.abs(ans)){
                ans = sum;
                a = arr[low];
                b = arr[high];
            }
            if(sum > 0){
                high--;
            }else low++;
        }
        sb.append(a).append(" ").append(b);
        System.out.println(sb);


    }
}
