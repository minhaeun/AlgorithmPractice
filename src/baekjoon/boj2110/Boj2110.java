package baekjoon.boj2110;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2110 {
    static int N, C, houses[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2110/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];

        for(int i = 0; i < N; i++){
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);
        int ans = 0;
        int left = 1, right = houses[N-1] - houses[0];
        while(left <= right){
            int mid = (left + right) / 2;
            int count = check(mid);
            if(count < C){
                right = mid - 1;
            }else{
                ans = mid;
                left = mid + 1;
            }
        }

        System.out.println(ans);

    }
    public static int check(int mid){
        int count = 1;
        int prev = houses[0];
        for(int i = 1; i < N; i++){
            if(mid <= houses[i] - prev){
                count ++;
                prev = houses[i];
            }
        }
        return count;
    }
}
