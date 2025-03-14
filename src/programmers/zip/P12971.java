package programmers.zip;

import java.util.ArrayList;
import java.util.Arrays;

public class P12971 {
    public static int solution(int sticker[]) {
        int len = sticker.length;
        int[] dp = new int[len];
        if(len == 1) return sticker[0];

        dp[0] = sticker[0];
        dp[1] = dp[0];

        for(int i = 2; i < len - 1; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }
        int answer = dp[len - 2];

        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i = 2; i < len; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        }
        return Math.max(answer, dp[len - 1]);
    }
    public static void main(String[] args) {

        int[] sticker1 = {14, 6, 5, 11, 3, 9, 2, 10};
        int[] sticker2 = {1, 3, 2, 5, 4};
        int[] sticker3 = {4, 3, 2, 9, 4};

        System.out.println(solution(sticker1));
        System.out.println(solution(sticker2));
        System.out.println(solution(sticker3));

    }
}
