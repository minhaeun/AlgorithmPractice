package baekjoon.boj7490;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Boj7490 {
    public static int T, N;
    public static ArrayList<String> ans;
    public static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj7490/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            dfs(1, 1, 0, 1, "1");
            System.out.println(sb);
        }


    }

    public static void dfs(int start, int num, int sum, int op, String str){
        if(start == N){
            sum += (num * op);
            if(sum == 0) sb.append(str + "\n");
            return;
        }

        dfs(start + 1, num * 10 + (start + 1), sum, op, str + " " + Integer.toString(start + 1));
        dfs(start + 1, start + 1, sum + (num*op), 1, str + "+" + Integer.toString(start + 1));
        dfs(start + 1, start + 1, sum + (num*op), -1, str + "-" + Integer.toString(start + 1));

    }
}
