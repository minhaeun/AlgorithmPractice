package programmers.zip;

import java.util.Arrays;

public class P12913 {
    public static int solution(int[][] land) {
        int answer = 0;
        int len = land.length;
        int[][] dp = new int[len][4];

        for(int i = 0; i < 4; i++){
            dp[0][i] = land[0][i];
        }

        for(int i = 1; i < len; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    if(j == k) continue;
                    dp[i][j] = Math.max(dp[i - 1][k] + land[i][j], dp[i][j]);
                }
            }
        }
        answer = Arrays.stream(dp[len-1]).max().getAsInt();
        return answer;
    }
    public static void main(String[] args) {
        int[][] land1 = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};

        System.out.println(solution(land1));

    }
}
