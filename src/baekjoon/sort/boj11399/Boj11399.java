package baekjoon.sort.boj11399;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11399 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("baekjoon/sort/boj11399/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // N명의 사람들을 시간이 적게 걸린는 순서로 정렬
        Arrays.sort(arr);

        int total = 0;
        int end = 0;
        while(end < N){
            int sum = 0;
            for(int i = 0; i <= end; i++){
                sum += arr[i];
            }
            total += sum;
            end++;
        }
        System.out.print(total);

    }
}
