package programmers.dp;

import java.util.Arrays;

public class P43105 {
    public static int solution(int[][] triangle) {
        int len = triangle.length;
        int[][] dp = new int[len][triangle[len - 1].length];
        dp[0][0] = triangle[0][0];
        for(int i = 0; i < len - 1; i++){
            int J = triangle[i].length;
            for(int j = 0; j < J; j++){
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j] + triangle[i + 1][j]);
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + triangle[i + 1][j + 1]);
            }
        }
        return Arrays.stream(dp[len - 1]).max().getAsInt();
    }
    public static void main(String[] args) {
        int[][] triangle1 = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println(solution(triangle1));
    }
}
