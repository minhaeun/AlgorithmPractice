package SWEA.SWEA1859;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1859 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());	// 2 <= N <= 1,000,000
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());	// 0 <= 매매가 <= 10,000
            }
            long sum = 0; // 100억
            int maxIndex = 0;
            int start = 0;
            while(start < N - 1) {
                maxIndex = start;
                for(int i = start; i < N; i++) {
                    if(arr[maxIndex] <= arr[i]) {
                        maxIndex = i;
                    }
                }
                int max = arr[maxIndex];
                for(int i = start; i < maxIndex; i++) {
                    sum += max - arr[i];
                }
                start = maxIndex + 1;
            }
            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.print(sb.toString());


    }
}
