package baekjoon.binary_search.boj1253;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1253_3 {
    public static int N, arr[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/binary_search/boj1253/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int count = 0;
        for(int i = 0; i < N; i++){
            int low = 0, high = N - 1;
            int value = arr[i];
            while(low < high){
                int sum = arr[low] + arr[high];

                if(sum > value) high--;
                else if(sum < value) low++;
                else{
                    if(low == i) low++;
                    else if(high == i) high--;
                    else{
                        count++;
                        break;
                    }

                }
            }
        }
        System.out.println(count);

    }
}
