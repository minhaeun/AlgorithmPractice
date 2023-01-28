package baekjoon.brute_force.boj15650;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15650 {
    static int N, M;
    static boolean nums[];
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj15650/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new boolean[N + 1];

        dfs(0, 1);
        System.out.println(sb);

    }

    public static void dfs(int count, int start){
        if(count == M){
            for(int i = 1; i < N + 1; i++){
                if(nums[i]) sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < N + 1; i++){
            if(nums[i]) continue;
            nums[i] = true;
            dfs(count + 1, i);
            nums[i] = false;
        }


    }
}
