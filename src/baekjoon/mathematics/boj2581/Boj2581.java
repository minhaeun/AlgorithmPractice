package baekjoon.mathematics.boj2581;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj2581 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/mathematics/boj2581/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[N + 1];

        arr[0] = true;
        arr[1] = true;

        for(int i = 2; i <= Math.sqrt(N); i++){
            if(arr[i])  continue;
            for(int j = i + i; j < N + 1; j += i){
                arr[j] = true;
            }
        }
        boolean flag = false;
        int sum = 0;
        int min = 0;
        for(int i = M; i < N + 1; i++){
            if(arr[i])  continue;
            if(!flag){
                min = i;
                flag = true;
            }
            sum += i;
        }
        if(sum == 0)    sb.append(-1);
        else sb.append(sum).append("\n").append(min);
        System.out.println(sb);
    }
}
