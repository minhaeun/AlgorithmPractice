package baekjoon.boj5525;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj5525_KMP {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj5525/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int S = Integer.parseInt(br.readLine());
        char[] text = br.readLine().toCharArray();
        char[] pattern = new char[2*N+1];

        for(int i = 0; i < 2*N+1; i+=2){
            pattern[i] = 'I';
        }
        for(int i = 1; i < 2*N+1; i+=2){
            pattern[i] = 'O';
        }

        int tLength = text.length, pLength = pattern.length;
        int[] pi = new int[pLength]; // 부분일치 테이블

        for(int i = 1, j = 0; i < pLength; i++){
            while(j > 0 && pattern[i] != pattern[j]){
                j = pi[j - 1];
            }
            if(pattern[i] == pattern[j]){
                pi[i] = ++j;
            }
            else    pi[i] = 0;
        }

        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0, j = 0; i < tLength; i++){
            while(j > 0 && text[i] != pattern[j]){
                j = pi[j - 1];
            }

            if(text[i] == pattern[j]){
                if(j == pLength - 1){
                    count++;
                    list.add((i + 1) - pLength);
                    j = pi[j];
                }
                else{
                    j++;
                }
            }
        }
        System.out.println(count);




    }
}
