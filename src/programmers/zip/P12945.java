package programmers.zip;

public class P12945 {
    public static int solution(int n) {
        int[] dp = new int[100001];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n] % 1234567;
    }
    public static void main(String[] args) {
        int n1 = 3;
        int n2 = 5;

        System.out.println(solution(n1));
        System.out.println(solution(n2));

    }
}
