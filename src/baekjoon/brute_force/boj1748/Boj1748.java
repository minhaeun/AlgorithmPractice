package baekjoon.brute_force.boj1748;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1748 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj1748/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int len = N.length();

        int ans = 0;
        for(int i = 0; i < len - 1; i++){
            ans += 9 * (int)Math.pow(10, i) * (i + 1);
        }

        int tmp = 0;
        for(int i = 0; i < len - 1; i++){
            tmp += 9 * (int)Math.pow(10, i);
        }
        ans += (Integer.parseInt(N) - tmp) * len;

        System.out.println(ans);

    }
}
