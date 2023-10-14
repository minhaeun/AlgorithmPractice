package baekjoon.binary_search.boj2776;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2776 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("baekjoon/binary_search/boj2343/boj2776/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] A = new int[N];
            st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < M; i++){
                int value = Integer.parseInt(st.nextToken());
                int start = 0;
                int end = N - 1;
                boolean flag = false;
                while(start <= end){
                    int midIndex = (start + end) / 2;
                    int midValue = A[midIndex];

                    if(midValue < value)    start = midIndex + 1;
                    else if(midValue > value)   end = midIndex - 1;
                    else{
                        flag = true;
                        break;
                    }
                }
                if(flag)    sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
        }
        System.out.println(sb);

    }
}
