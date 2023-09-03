package baekjoon.boj20437;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj20437 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj20437/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            ArrayList<Integer>[] list = new ArrayList[26];
            for(int i = 0; i < 26; i++) list[i] = new ArrayList<>();
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

            for(int i = 0; i < W.length(); i++){
                int idx = W.charAt(i) - 'a';
                list[idx].add(i);
                if(list[idx].size() == K){
                    int len = i - list[idx].get(0) + 1;
                    min = Math.min(len, min);
                    max = Math.max(len, max);
                    list[idx].remove(0);
                }
            }
            if(min == Integer.MAX_VALUE)    sb.append(-1).append("\n");
            else sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
