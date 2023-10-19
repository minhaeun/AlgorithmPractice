package baekjoon.boj9251;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj9251 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj9251/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char str1[] = br.readLine().toCharArray();
        char str2[] = br.readLine().toCharArray();

        int len1 = str1.length;
        int len2 = str2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(str1[i - 1] == str2[j - 1])  dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[len1][len2]);

    }
}
