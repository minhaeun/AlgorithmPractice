package baekjoon.sort.boj1920;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1920 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/sort/boj1920/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);



        for (int num : arr2) {
            int start = 0;
            int end = N - 1;

            while(true){
                int mid = (start + end) / 2;

                if(arr[mid] == num){
                    System.out.println(1);
                    break;
                }else if(arr[mid] > num){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
                if(start > end){
                    System.out.println(0);
                    break;
                }
            }
        }


    }
}
