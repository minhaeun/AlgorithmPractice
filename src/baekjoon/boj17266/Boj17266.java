package baekjoon.boj17266;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17266 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj17266/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            int index = Integer.parseInt(st.nextToken());
            arr[index] = true;
        }

        int start = -1, mid = -1, end = -1, before = 0;
        for(int i = 0; i < N + 1; i++){
            if(arr[i] && start == -1){
                start = i;
                before = i;
            }
            else if(arr[i]){
                int tmp = (int) Math.ceil((i - before) / 2.0);
                before = i;
                mid = Math.max(tmp, mid);
            }
        }
        end = N - before;

        int max = 0;
        if(start > mid) max = start;
        else    max = mid;

        if(max < end)   max = end;
        System.out.println(max);





    }
}
