package baekjoon.boj20922;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20922 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj20922/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] count = new int[100002];
        int[] arr = new int[N + 1];


        st = new StringTokenizer(br.readLine(), " ");
        int len = 0, ans = 0, left = 1, right = 1;
        for(int i = 1; i < N + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(right <= N){
            if(count[arr[right]] < K){
                count[arr[right]]++;
                right++;
            }else{
                len = right - left;
                ans = Math.max(len, ans);
                count[arr[left]]--;
                left++;
            }
        }
        len = right - left;
        ans = Math.max(len, ans);
        System.out.println(ans);
    }
}
