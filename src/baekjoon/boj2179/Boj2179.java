package baekjoon.boj2179;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj2179 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2179/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            list.add(str);
        }

        int before = 0;
        int after = 0;
        int max = 0;

        for(int i = 0; i < N - 1; i++){
            String str1 = list.get(i);
            for(int j = i + 1; j < N; j++){
                String str2 = list.get(j);
                int count = 0;
                int len = Math.min(str1.length(), str2.length());
                for(int k = 0;k < len; k++){
                    if(str1.charAt(k) != str2.charAt(k))    break;
                    count++;
                }
                if(max < count){
                    max = count;
                    before = i;
                    after = j;
                }
            }
        }
        System.out.println(list.get(before));
        System.out.println(list.get(after));

    }
}
