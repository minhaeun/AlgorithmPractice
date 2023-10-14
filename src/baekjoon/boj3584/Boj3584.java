package baekjoon.boj3584;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj3584 {
    public static int arr[], ans = 0;
    public static boolean[] visited;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj3584/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visited = new boolean[N + 1];
            for(int i = 0; i < N - 1; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[b] = a;
            }

            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dfs(a);
            dfs(b);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int num){
        if(visited[num]){
            ans = num;
            return;
        }
        visited[num] = true;
        if(arr[num] == 0){
            return;
        }
        dfs(arr[num]);
    }
}
