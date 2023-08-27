package baekjoon.boj2607;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj2607 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2607/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) - 1;

        String word = br.readLine();
        int len = word.length();
        int[] alpha = new int[26];

        for(int i = 0; i < len; i++){
            alpha[word.charAt(i) - 'A']++;
        }

        int ans = 0;
        while(N-- > 0){
            int[] tmp = alpha.clone();
            String str = br.readLine();
            int count = 0;
            for(int i = 0; i < str.length(); i++){
                if(tmp[str.charAt(i) - 'A']-- > 0)  count++;
            }
            if(len == str.length() && (count == len || count == len - 1)) ans++;
            else if(len - 1 == str.length() && count == str.length())  ans++;
            else if(len + 1 == str.length() && count == len)    ans++;
        }
        System.out.println(ans);

    }
}
