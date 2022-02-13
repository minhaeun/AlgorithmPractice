package baekjoon.boj2477;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj2477 {
    static int K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj2477/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        arr = new int[7];
        int maxWidth = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        int value = 0;
        int w = 0, h = 0;

        for(int t = 0; t < 6; t++){
            st = new StringTokenizer(br.readLine(), " ");
            int opt = Integer.parseInt(st.nextToken());
            if(opt == 4 || opt == 3){
                value = Integer.parseInt(st.nextToken());
                if(maxHeight < value){
                    maxHeight = value;
                    w = t;
                }
            }
            if(opt == 1 || opt == 2){
                value = Integer.parseInt(st.nextToken());
                if(maxWidth < value){
                    maxWidth = value;
                    h = t;
                }
            }
            arr[t] = value;
        }

        int area = maxHeight * maxWidth;


        int subWidth = 0;
        int subHeight = 0;
        int left = 0, right = 0;

        if(w == 0)    left = 5;
        else    left = w - 1;
        if(w == 5)    right = 0;
        else    right = w + 1;
        subHeight = Math.abs(arr[left] - arr[right]);

        if(h == 0)  left = 5;
        else    left = h - 1;
        if(h == 5)    right = 0;
        else    right = h + 1;

        subWidth = Math.abs(arr[left] - arr[right]);


        int subArea = subHeight * subWidth;

        System.out.println((area - subArea) * K);


    }
}
