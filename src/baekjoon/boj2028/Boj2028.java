package baekjoon.boj2028;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj2028 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2028/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int nPow = n * n;
            boolean isNo = false;
            while(n != 0){
                int a = n % 10;
                int b = nPow % 10;
                if(a != b){
                    sb.append("NO\n");
                    isNo = true;
                    break;
                }
                n /= 10;
                nPow /= 10;
            }
            if(!isNo)   sb.append("YES\n");
        }
        System.out.println(sb);
    }
}
