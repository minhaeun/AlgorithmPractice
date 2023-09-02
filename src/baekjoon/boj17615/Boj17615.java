package baekjoon.boj17615;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj17615 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj17615/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int count = 0, min = N;
        boolean flag = false;
        for(int i = 0; i < N; i++){
            if(flag && str.charAt(i) == 'R')    count++;
            if(str.charAt(i) == 'B')    flag = true;
        }

        if(min > count) min = count;


        count = 0; flag = false;
        for(int i = 0; i  < N; i++){
            if(flag && str.charAt(i) == 'B')    count++;
            if(str.charAt(i) == 'R')    flag = true;
        }
        if(min > count) min = count;

        count = 0; flag = false;
        for(int i = N - 1; i >= 0; i--){
            if(flag && str.charAt(i) == 'R')    count++;
            if(str.charAt(i) == 'B')    flag = true;
        }
        if(min > count) min = count;

        count = 0; flag = false;
        for(int i = N - 1; i >= 0; i--){
            if(flag && str.charAt(i) == 'B')    count++;
            if(str.charAt(i) == 'R')    flag = true;
        }
        if(min > count) min = count;

        System.out.println(min);


    }
}
