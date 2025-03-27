package baekjoon.boj12891;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj12891 {
    public static int[] count, arr;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj12891/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] str = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        arr = new int[4];

        for(int i = 0; i < 4; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count = new int[4];
        for(int i = 0; i < P; i++){
            add(str[i]);
        }
        int ans = 0;
        for(int i = P; i < S; i++){
            if(check()) ans++;
            sub(str[i - P]);
            add(str[i]);
        }
        if(check()) ans++;

        System.out.println(ans);
    }
    public static boolean check(){
        for(int i = 0; i < 4; i++){
            if(count[i] < arr[i]) return false;
        }
        return true;
    }
    public static void add(char ch){
        switch(ch){
            case 'A':
                count[0]++;
                break;
            case 'C':
                count[1]++;
                break;
            case 'G':
                count[2]++;
                break;
            case 'T':
                count[3]++;
                break;
        }
    }
    public static void sub(char ch){
        switch(ch){
            case 'A':
                count[0]--;
                break;
            case 'C':
                count[1]--;
                break;
            case 'G':
                count[2]--;
                break;
            case 'T':
                count[3]--;
                break;
        }
    }
}
