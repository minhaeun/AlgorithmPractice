package baekjoon.binary_search.boj2776;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2776_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/binary_search/boj2776/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[] arr;

        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            OUTER : for(int i = 0; i < M; i++){
                int num = Integer.parseInt(st.nextToken());
                int low = 0;
                int high = N - 1;
                while(low <= high){
                    int midIndex = (low + high) / 2;
                    int midValue = arr[midIndex];

                    if(midValue < num){
                        low = midIndex + 1;
                    }else if(midValue > num){
                        high = midIndex - 1;
                    }else{
                        sb.append("1\n");
                        continue OUTER;
                    }
                }
                sb.append("0\n");
            }
        }
        System.out.println(sb);



    }
}
