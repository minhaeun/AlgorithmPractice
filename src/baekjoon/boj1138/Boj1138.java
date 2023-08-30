package baekjoon.boj1138;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1138 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1138/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] ans = new int[N];

        Arrays.fill(ans, -1);
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            int count = 0;
            int value = Integer.parseInt(st.nextToken());
            for(int j = 0; j < N; j++){
                if(ans[j] != -1)    continue;
                if(value != count){
                    count++;
                    continue;
                }
                ans[j] = i + 1;
                break;
            }

        }

        for(int value : ans) sb.append(value).append(" ");
        System.out.println(sb);
    }
}
