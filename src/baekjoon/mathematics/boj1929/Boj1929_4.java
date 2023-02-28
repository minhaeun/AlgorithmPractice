package baekjoon.mathematics.boj1929;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1929_4 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/mathematics/boj1929/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[N + 1];
        arr[0] = true;
        arr[1] = true;

        for(int i = 2; i <= Math.sqrt(N); i++){
            if(arr[i])  continue;
            for(int j = i + i; j <= N; j += i){
                arr[j] = true;
            }
        }

        for(int i = M; i <= N; i++){
            if(!arr[i]) System.out.println(i);
        }



    }
}
