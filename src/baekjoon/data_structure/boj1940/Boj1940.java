package baekjoon.data_structure.boj1940;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1940 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj1940/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int count = 0;
        int start_index = 0;
        int end_index = N - 1;

        while(start_index < end_index){
            int sum = arr[start_index] + arr[end_index];
            if(sum < M){
                start_index++;
            }
            else if(sum > M){
                end_index--;
            }else{
                count++;
                end_index--;
                start_index++;
            }
        }

        System.out.println(count);



    }
}
