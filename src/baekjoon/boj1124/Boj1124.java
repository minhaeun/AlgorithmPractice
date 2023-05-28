package baekjoon.boj1124;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1124 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1124/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        boolean[] prime = new boolean[100001];
        int[] count = new int[100001];
        prime[0] = prime[1] = true;
        for(int i = 2; i < 100001; i++){
            if(prime[i])    continue;
            for(int j = i + i; j < 100001; j += i){
                prime[j] = true;
                int tmp = j;
                while(tmp % i == 0){
                    tmp /= i;
                    count[j]++;
                }
            }
        }

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int res = 0;
        for(int i = A; i <= B; i++){
            if(!prime[count[i]])    res++;
        }
        System.out.println(res);

    }
}
