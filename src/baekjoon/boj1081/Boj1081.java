package baekjoon.boj1081;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1081 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1081/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String n = st.nextToken();
        String m = st.nextToken();
        long temp = page(m) - page(n);
        for(int i = 0; i < n.length(); i++){
            temp += n.charAt(i) - '0';
        }
        System.out.println(temp);

    }

    public static long page(String str){
        long returnValue = 0;
        long[] page = new long[10];
        long[] pre = new long[10];
        long[] ans = new long[10];

        int len = str.length();

        ArrayList<long[]> index = new ArrayList<>();
        index.add(page.clone());
        long cnt = 1;
        for(int i = 0; i < len; i++){
            for(int j = 0; j <= 9; j++){
                page[j] *= 10;
                page[j] += cnt;
            }
            index.add(page.clone());
            cnt *= 10;
        }
        for(int i = 0; i < str.length(); i++, len--){
            int cur = str.charAt(i) - '0';
            long[] curIdx = index.get(len - 1);
            long repeat = (long) Math.pow(10, len - 1);
            for(int j = 0; j <= 9; j++){
                ans[j] += curIdx[j]*cur;
                ans[j] += pre[j]*repeat*cur;
            }
            for(int j = 0; j < cur; j++){
                ans[j] += repeat;
            }
            pre[cur]++;
        }
        for(int j = 0; j <= 9; j++) ans[j] += pre[j];
        for(int i = 0; i < str.length(); i++){
            ans[0] -= Math.pow(10, i);
        }
        for(int i = 0; i <= 9;  i++){
            returnValue += i * ans[i];
        }
        return returnValue;

    }
}
