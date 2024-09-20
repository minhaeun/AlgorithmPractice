package baekjoon.boj2512;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2512_4 {
    public static int N, arr[], M;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2512/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int low = 1;
        int high = arr[N - 1];
        int ans = 0;
        while(low <= high){
            int mid = (low + high) / 2;
            int sum = 0;
            for(int i = 0; i < N; i++){
                if(arr[i] > mid) sum += mid;
                else sum += arr[i];
            }

            if(sum > M){
                high = mid - 1;
            }
            else {
                low = mid + 1;
                ans = mid;
            }

        }
        System.out.println(ans);



    }
}
