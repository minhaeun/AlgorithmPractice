package baekjoon.boj2512;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2512_3 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2512/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());

        int low = arr[0];
        int high = arr[N - 1];
        int ans = 0;

        while(low <= high){
            int mid = (low + high) / 2;
            int total = 0;
            for(int i = 0; i < N; i++){
                if(arr[i] > mid)   total += mid;
                else total += arr[i];
            }

            if(total <= M){
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }

        System.out.println(ans);



    }
}
