package baekjoon.boj19637;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj19637 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj19637/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] std = new String[N];
        int[] powers = new int[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            std[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            int low = 0, high = N - 1, mid = 0;
            long value = Long.parseLong(br.readLine());
            while(low <= high){
                mid = (low + high) / 2;
                if(value > powers[mid]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            sb.append(std[low]).append("\n");
        }



        System.out.println(sb);
    }
}
