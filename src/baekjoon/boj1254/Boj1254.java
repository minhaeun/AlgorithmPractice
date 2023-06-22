package baekjoon.boj1254;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1254 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1254/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int ans = s.length();
        for(int i = 0; i < s.length(); i++){
            if(isPalind(s.substring(i)))    break;
            ans++;
        }
        System.out.println(ans);

    }

    public static boolean isPalind(String str){
        int start = 0;
        int last = str.length() - 1;
        while(start <= last){
            if(str.charAt(start) != str.charAt(last))   return false;
            start++;
            last--;
        }
        return true;
    }
}
