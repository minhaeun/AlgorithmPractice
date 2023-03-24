package baekjoon.binary_search.boj9024;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class Boj9024 {
    public static int T, N, K, num[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/binary_search/boj9024/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            num = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++){
                num[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(num);

            int left = 0;
            int right = N-1;
            int min = Integer.MAX_VALUE;
            int count = 0;
            while(left < right){
                int sum = num[left] + num[right];
                int value = Math.abs(sum - K);

                if(min >= value) {
                    if(min > value) count = 0;
                    min = value;
                    count++;
                }
                if(sum >= K)    right--;
                else left++;

            }
            sb.append(count).append("\n");

        }
        System.out.println(sb);





    }
}
