package baekjoon.binary_search.boj1253;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1253 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("baekjoon/binary_search/boj1253/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        int count = 0;

        for(int i = 0; i < N; i++){
            int start_index = 0;
            int end_index = N - 1;

            while(start_index < end_index){
                int sum = A[start_index] + A[end_index];
                if(sum < A[i]){
                    start_index++;
                }else if(sum > A[i]){
                    end_index--;
                }else{
                    if(start_index == i)    start_index++;
                    else if(end_index == i) end_index--;
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
