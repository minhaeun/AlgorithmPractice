package baekjoon.recursion.boj2961;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2961 {
    static int N, min;
    static int[] sour, bitter;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/recursion/boj2961/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        sour = new int[N];
        bitter = new int[N];
        isSelected = new boolean[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            sour[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }
        min = Integer.MAX_VALUE;
        generateSubset(0);
        System.out.println(min);
    }
    public static void generateSubset(int count){
        boolean flag = false;
        if(count == N){
            int sScore = 1;
            int bScore = 0;
            for(int i = 0; i < N; i++){
                if(isSelected[i]){
                    sScore *= sour[i];
                    bScore += bitter[i];
                    flag = true;
                }
            }if(!flag)  return;
            min = Math.min(min, Math.abs(sScore - bScore));
            return;

        }
        isSelected[count] = true;
        generateSubset(count + 1);
        isSelected[count] = false;
        generateSubset(count + 1);
    }


}
