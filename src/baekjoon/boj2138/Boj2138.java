package baekjoon.boj2138;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj2138 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2138/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();

        int ans1 = 1, ans2 = 0;

        int[] after = new int[N];
        int[] tmp = new int[N];
        int[] before = new int[N];

        for(int i = 0; i < N; i++){
            before[i] = str1.charAt(i) - '0';
            tmp[i] = str1.charAt(i) - '0';
            after[i] = str2.charAt(i) - '0';
        }

        before[0] = 1-before[0];
        before[1] = 1-before[1];

        for(int i = 1; i < N; i++){
            if(before[i - 1] != after[i - 1]){
                before[i - 1] = 1 - before[i - 1];
                before[i] = 1 - before[i];
                ans1++;
                if(i != N - 1)  before[i + 1] = 1 - before[i + 1];
            }
            if(tmp[i - 1] != after[i - 1]){
                tmp[i - 1] = 1 - tmp[i - 1];
                tmp[i] = 1 - tmp[i];
                ans2++;
                if(i != N - 1)  tmp[i + 1] = 1 - tmp[i + 1];
            }
        }
        if(before[N - 1] != after[N - 1])   ans1 = Integer.MAX_VALUE;
        if(tmp[N - 1] != after[N - 1])  ans2 = Integer.MAX_VALUE;

        if(ans1 == Integer.MAX_VALUE && ans2 == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(Math.min(ans1, ans2));

    }

}
