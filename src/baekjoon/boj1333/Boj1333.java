package baekjoon.boj1333;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1333 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1333/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] time = new int[5000];

        int sec = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < L; j++){
                time[sec++] = 1;
            }
            sec += 5;
        }
        sec = 0;
        while(true){
            if(time[sec] == 0){
                System.out.println(sec);
                break;
            }
            sec += D;
        }




    }
}
