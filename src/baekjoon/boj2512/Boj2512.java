package baekjoon.boj2512;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2512 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2512/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] budget = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            budget[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        int total = Integer.parseInt(br.readLine());
        int low = 1, high = Arrays.stream(budget).max().getAsInt();
        while(low <= high){
            int mid = (low + high) / 2;

            int sum = 0;
            for(int value : budget){
                if(value <= mid)    sum += value;
                else    sum += mid;
            }

            if(sum > total)     high = mid - 1;
            else if(sum == total){
                ans = mid;
                break;
            }
            else {
                ans = mid;
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
