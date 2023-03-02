package baekjoon.binary_search.boj1300;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1300 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("baekjoon/binary_search/boj1300/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        long start = 1, end = K;
        long ans = 0;

        while(start <= end){
            long mid = (start + end) / 2;
            long count = 0;
            for(int i = 1; i <= N; i++){
                count += Math.min(mid / i, N);
            }
            if(count < K)   start = mid + 1;
            else{
                ans = mid;
                end = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
