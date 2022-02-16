package baekjoon.boj2343;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2343 {
    static int N, M;
    static int[] arr;
    static int low, high;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj2343/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int sum = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            high += arr[i];
            low = Math.max(low, arr[i]);
        }
        binarySearch();

        System.out.println(low);

    }

    static void binarySearch(){
        int mid, sum, count;

        while(low <= high){
            mid = (low + high) / 2;
            sum = 0;
            count = 0;

            for(int i = 0; i < N; i++){
                if(sum + arr[i] > mid){
                    sum = 0;
                    count++;
                }

                sum += arr[i];
            }

            if(sum > 0) count++;
            if(count <= M)  high = mid - 1;
            else    low = mid + 1;

        }
    }
}
