package baekjoon.boj2110;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2110_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2110/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int low = 1, high = arr[N - 1] - arr[0], mid = 0, result = 0;
        while(low <= high){
            mid = (low + high) / 2;

            int check = 1;
            int std = arr[0];
            for(int i = 1; i < N; i++){
                if(arr[i] - std < mid)  continue;
                std = arr[i];
                check++;
            }
            if(check >= C){
                result = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        System.out.println(result);

    }
}
