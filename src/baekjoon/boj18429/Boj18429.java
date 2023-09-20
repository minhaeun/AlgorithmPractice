package baekjoon.boj18429;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18429 {
    public static int N, K, arr[], ans = 0;
    public static boolean visited[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj18429/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        back(500, 0);
        System.out.println(ans);
    }
    public static void back(int sum, int idx){
        if(idx == N){
            ans++;
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i] || (sum + arr[i] - K) < 500) continue;
            visited[i] = true;
            back(sum + arr[i] - K, idx + 1);
            visited[i] = false;
        }
    }
}
