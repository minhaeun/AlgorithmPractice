package baekjoon.brute_force.boj15649;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15649 {
    public static boolean visited[];
    public static int arr[];
    public static int N, M;
    public static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj15649/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        arr = new int[N + 1];

        dfs(0);
        System.out.println(sb);


    }

    public static void dfs(int count){
        if(count == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i < N + 1; i++){
            if(visited[i])  continue;
            visited[i] = true;
            arr[count] = i;
            dfs(count + 1);
            visited[i] = false;
        }
    }

}
