package programmers.zip;

import java.util.Arrays;

public class P154538 {
    public static int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, 1000001);
        dp[x] = 0;
        for(int i = x; i < y + 1; i++){
            if(i + n <= y) dp[i + n] = Math.min(dp[i] + 1, dp[i + n]);
            if(i * 2 <= y) dp[i * 2] = Math.min(dp[i] + 1, dp[i * 2]);
            if(i * 3 <= y) dp[i * 3] = Math.min(dp[i] + 1, dp[i * 3]);
        }
        if(dp[y] == 1000001) return -1;
        return dp[y];
    }
    public static void main(String[] args) {
        int x1 = 10, y1 = 40, n1 = 5;
        int x2 = 10, y2 = 40, n2 = 30;
        int x3 = 2, y3 = 5, n3 = 4;

        System.out.println(solution(x1, y1, n1));
        System.out.println(solution(x2, y2, n2));
        System.out.println(solution(x3, y3, n3));

    }
}
