package baekjoon.boj1740;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1740 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1740/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long answer = 0;
        int count = 0;
        while(N > 0){
            if((N & 1) == 1)    answer += power(3, count);
            count++;
            N = (N >> 1);
        }
        System.out.println(answer);
    }

    public static long power(long a, long b){
        if(b == 0)  return 1;
        if(b == 1)  return a;

        long temp = power(a, b / 2);

        if(b % 2 == 0)  return temp*temp;
        else return (temp * temp) * a;
    }
}
