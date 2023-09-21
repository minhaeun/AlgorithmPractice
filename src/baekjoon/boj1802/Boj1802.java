package baekjoon.boj1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1802 {
    public static char[] paper;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1802/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++){
            paper = br.readLine().toCharArray();
            int len = paper.length;;
            if(check(0, len - 1))   sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
    public static boolean check(int start, int end){
        if(start == end)    return true;
        int mid = (start + end) / 2;
        for(int i = start; i < mid; i++){
            if(paper[i] == paper[end - i])  return false;
        }
        return check(start, mid - 1) && check(mid + 1, end);
    }
}
