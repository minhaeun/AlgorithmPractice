package programmers.dp;

public class P42898 {
    public static int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;

        int[][] dp = new int[n + 1][m + 1];
        int len = puddles.length;
        for(int i = 0; i < len; i++){
            dp[puddles[i][1]][puddles[i][0]] = -1;
        }

        dp[1][1] = 1;
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(dp[i][j] == -1) continue;
                if(dp[i][j - 1] != -1) dp[i][j] += dp[i][j - 1] % mod;
                if(dp[i - 1][j] != -1) dp[i][j] += dp[i - 1][j] % mod;
            }
        }
        return dp[n][m] % mod;
    }
    public static void main(String[] args) {
        int m1 = 4, n1 = 3, puddles[][] = {{2, 2}};

        System.out.println(solution(m1, n1, puddles));

    }
}
