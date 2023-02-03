package baekjoon.brute_force.boj15657;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15657_2 {
    static int N, M, nums[], ans[];
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj15657/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        ans = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        dfs(0, 0);
        System.out.println(sb);
    }

    public static void dfs(int count, int start){
        if(count == M){
            for(int i = 0; i < M; i++){
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < N; i++){
            ans[count] = nums[i];
            dfs(count + 1, i);
        }
    }
}
