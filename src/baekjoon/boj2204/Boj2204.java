package baekjoon.boj2204;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2204 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2204/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        String list[];

        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            list = new String[N];

            for(int i = 0; i < N; i++){
                list[i] = br.readLine();
            }
            Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
            System.out.println(list[0]);
        }



    }
}
