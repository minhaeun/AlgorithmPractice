package baekjoon.boj2512;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2512_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2512/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        int sum = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        if(sum <= M){
            System.out.println(arr[N - 1]);
            return;
        }


        int low = 1;
        int high = arr[N - 1];
        int ans = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            int value = 0;
            for(int i = 0; i < N; i++){
                if(arr[i] > mid)    value += mid;
                else value += arr[i];
            }
            if(value > M){
                high = mid - 1;
            }else if(value < M){
                ans = mid;
                low = mid + 1;
            }else{
                ans = mid;
                break;
            }
        }

        System.out.println(ans);
    }
}
