package baekjoon.boj1459;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1459 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1459/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long ans = 0;
        if(2 * w < s)   ans = (x + y) * w;
        else if(2 * w > 2 * s){
            if((x + y) % 2 == 0)    ans = Math.max(x, y) * s;
            else{
                ans = (Math.max(x, y) - 1) * s;
                ans += w;
            }
        }else{
            if(x == y)  ans = s * x;
            else{
                ans = Math.min(x * s, y * s);
                ans += Math.abs(x - y) * w;
            }
        }
        System.out.println(ans);
    }
}
