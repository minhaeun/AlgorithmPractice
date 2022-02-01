package baekjoon.binary_search.boj2805;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2805 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/binary_search/boj2805/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int right = arr[n-1];
        int left = 0;
        int answer = 0;
        while(right >= left){
            long sum = 0;
            int mid = (right + left) / 2;
            answer = mid;
            for(int i = arr.length - 1 ; i >= 0; i--){
                if(arr[i] - mid >= 0){
                    sum += arr[i] - mid;
                }else   break;
            }
            if(sum > m){
                left = mid + 1;
            }else if(sum < m){
                right = mid - 1;
            }else{
                System.out.println(mid);
                return;
            }
        }
        System.out.println(right);

    }
}
