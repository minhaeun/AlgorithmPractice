package baekjoon.brute_force.boj15651;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15651 {

    static int N, M, nums[];
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj15651/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];

        dfs(0);
        System.out.print(sb);
    }

    public static void dfs(int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            nums[count] = i;
            dfs(count + 1);
        }

    }

}
