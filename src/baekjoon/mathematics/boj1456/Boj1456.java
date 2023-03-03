package baekjoon.mathematics.boj1456;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1456 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/mathematics/boj1456/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        boolean[] arr = new boolean[10000001];

        arr[0] = true;
        arr[1] = true;

        for(int i = 2; i <= Math.sqrt(arr.length); i++){
            if(arr[i])  continue;
            for(int j = i + i; j < arr.length; j += i){
                arr[j] = true;
            }
        }

        int count = 0;
        for(int i = 2; i < 10000001; i++){
            if(arr[i])  continue;
            long tmp = i;
            while((double)i <= (double)B / (double)tmp){
                if((double)i >= (double)A / (double)tmp)  count++;
                tmp *= i;
            }
        }
        System.out.println(count);





    }
}
