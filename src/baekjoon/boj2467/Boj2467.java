package baekjoon.boj2467;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2467 {
    static int N, arr[], answer[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2467/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = N-1;
        int min = Integer.MAX_VALUE;
        answer = new int[2];
        while(low < high){
            int value = arr[low] + arr[high];
            int tmp = Math.abs(value);
            if(min > tmp){
                min = tmp;
                answer[0] = arr[low];
                answer[1] = arr[high];
            }

            if(value < 0)   low += 1;
            else if(value == 0) break;
            else high -= 1;
        }

        sb.append(answer[0]).append(" ").append(answer[1]);
        System.out.println(sb.toString());

    }
}
