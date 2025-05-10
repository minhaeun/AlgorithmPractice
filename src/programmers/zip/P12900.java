package programmers.zip;

public class P12900 {
    public static int solution(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n1 = 4;
        System.out.println(solution(n1));
    }
}
