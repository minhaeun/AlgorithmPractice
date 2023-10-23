package baekjoon.boj1788;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1788 {
    public static int[] dp;
    public static final int MOD = 1000000000;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1788/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n > 0){
            System.out.println(1);
        }else if(n < 0){
            n = -n;
            if(n % 2 == 0) System.out.println(-1);
            else System.out.println(1);
        }else{
            System.out.println(0);
        }

        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fibo(n));

    }
    public static int fibo(int x){
        if(x == 0)  return 0;
        if(x == 1 || x == 2)    return 1;
        if(dp[x] != -1) return dp[x];
        return dp[x] = (fibo(x - 1) % MOD + fibo(x - 2)% MOD) % MOD;
    }
}
