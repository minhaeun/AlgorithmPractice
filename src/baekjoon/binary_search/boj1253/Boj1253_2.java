package baekjoon.binary_search.boj1253;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1253_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("baekjoon/binary_search/boj1253/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int count = 0;
        for(int i = 0; i <= N - 1; i++){
            int low = 0;
            if(low == i)    low = 1;
            int high = N - 1;
            if(high == i)   high = N - 2;
            int valueIndex = i;
            int value = arr[i];
            while(low < high){
                int sum = arr[low] + arr[high];
                if(sum < value){
                    low++;
                    if(low == valueIndex)   low++;
                }else if(sum > value){
                    high--;
                    if(high == valueIndex)  high--;
                }else{
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);


    }
}
