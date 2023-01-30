package baekjoon.brute_force.boj15652;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15652 {
    static int N, M, nums[];
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj15652/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[M + 1];

        dfs(0, 1);
        System.out.print(sb);

    }

    public static void dfs(int count, int start) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N + 1; i++) {
            nums[count] = i;
            dfs(count + 1, i);
        }
    }
}
