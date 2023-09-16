package baekjoon.boj13144;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13144 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj13144/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] count = new int[100001];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = 0;
        long ans = 0;
        while(r < N){
            count[arr[r]]++;
            if(count[arr[r]] == 2){
                while(count[arr[r]] == 2){
                    count[arr[l]]--;
                    l++;
                }
            }
            ans += (r - l + 1);
            r++;
        }
        System.out.println(ans);


    }
}
