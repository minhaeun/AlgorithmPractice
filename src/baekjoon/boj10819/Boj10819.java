package baekjoon.boj10819;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj10819 {
    public static boolean[] v;
    public static int[] arr;
    public static int answer = 0;
    public static int n;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj10819/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        v = new boolean[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(answer);
    }
    public static void dfs(int count, int bf, int sum){
        if(count == n){
            answer = Math.max(answer, sum);
            return;
        }
        for(int i = 0; i < n; i++){
            if(v[i])    continue;
            v[i] = true;
            dfs(count + 1, arr[i], count == 0 ? 0 : sum + Math.abs(bf - arr[i]));
            v[i] = false;
        }
    }
}
