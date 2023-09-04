package baekjoon.boj2467;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2467_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2467/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = N - 1;
        int min = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while(low < high){
            int value = arr[low] + arr[high];
            int tmp = Math.abs(value);

            if(min > tmp){
                min = tmp;
                ans[0] = arr[low];
                ans[1] = arr[high];
            }

            if(value < 0)   low++;
            else if(value > 0)  high--;
            else break;
        }

        Arrays.sort(ans);

        System.out.println(ans[0] + " " + ans[1]);




    }
}
