package baekjoon.brute_force.boj1107;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1107_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj1107/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[] btn = new boolean[10];

        if(N == 100){
            System.out.println(0);
            return;
        }
        if(M != 0)
            st = new StringTokenizer(br.readLine(), " ");

        for(int m = 0; m < M; m++){
            btn[Integer.parseInt(st.nextToken())] = true;
        }
        int min = Math.abs(N - 100);
        for(int i = 0; i < 1000001; i++){
            String str = Integer.toString(i);
            boolean isPossible = true;
            int len = str.length();
            for(int j = 0; j < len; j++){
                int button = str.charAt(j) - '0';
                if(btn[button]){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible){
                int count = len + Math.abs(i - N);
                min = Math.min(min, count);
            }
        }
        System.out.println(min);

    }
}
