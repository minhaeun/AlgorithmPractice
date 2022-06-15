package baekjoon.boj14501;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14501 {
    static int N, arr[][];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj14501/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][];
        int dp[] = new int[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{T, P};
        }

        for (int i = 0; i < N; i++) {
            int lastDay = arr[i][0] + i;
            dp[i+1] = Math.max(dp[i], dp[i+1]);
            if (lastDay > N) continue;
            dp[lastDay] = Math.max(dp[i] + arr[i][1], dp[lastDay]);
        }

        System.out.println(dp[N]);

    }
}
