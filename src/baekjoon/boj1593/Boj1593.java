package baekjoon.boj1593;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1593 {
    public static int g, s, alpha[], check[];
    public static String w;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1593/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        g = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        alpha = new int[52];
        check = new int[52];
        w = br.readLine();
        for(int i = 0; i < w.length(); i++){
            if(w.charAt(i) >= 'a' && w.charAt(i) <= 'z')    alpha[w.charAt(i) - 'a']++;
            else alpha[w.charAt(i) - 'A' + 26]++;
        }
        String str = br.readLine();
        Queue<Character> queue = new LinkedList<>();

        for(int i = 0; i < g; i++){
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z')    check[str.charAt(i) - 'a']++;
            else check[str.charAt(i) - 'A' + 26]++;
            queue.offer(str.charAt(i));
        }
        int count = 0;
        if(Arrays.equals(check, alpha))    count++;
        for(int i = g; i < s; i++){
            char ch = queue.poll();
            if(ch >= 'a' && ch <= 'z')  check[ch - 'a']--;
            else check[ch - 'A' + 26]--;
            char ch2 = str.charAt(i);
            queue.offer(ch2);
            if(ch2 >= 'a' && ch2 <= 'z') check[ch2 - 'a']++;
            else check[ch2 - 'A' + 26]++;
            if(Arrays.equals(check, alpha)) count++;
        }

        System.out.println(count);
    }

}
