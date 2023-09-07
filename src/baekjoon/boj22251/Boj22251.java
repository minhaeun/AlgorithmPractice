package baekjoon.boj22251;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj22251 {
    public static int N, K, P, X;
    public static boolean[][] display = {{true, true, true, true, true, true, false}, // 0
                                        {false, false, false, true, true, false, false}, //1
                                        {false, true, true, false, true, true, true}, // 2
                                        {false, false, true, true, true, true, true}, // 3
                                        {true, false, false, true, true, false, true}, // 4
                                        {true, false, true, true, false, true, true}, // 5
                                        {true, true, true, true, false, true, true}, // 6
                                        {false, false, false, true, true, true, false}, // 7
                                        {true, true, true, true, true, true, true}, // 8
                                        {true, false, true, true, true, true, true} // 9
    };
    public static long count = 0;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj22251/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] digit = change(X);

        for(int i = 1; i <= N; i++){
            if(i == X)  continue;
            if(reverse(i, digit))   count++;
        }
        System.out.println(count);

    }

    public static int[] change(int x){
        int[] result = new int[K];
        for(int i = K - 1; i >= 0; i--){
            result[i] = x % 10;
            x /= 10;
        }
        return result;
    }
    public static boolean reverse(int target, int[] digit){
        int[] arr = change(target);

        int diffCount = 0;
        for(int i = 0; i < K; i++){
            for(int j = 0; j < 7; j++){
                if(display[digit[i]][j] != display[arr[i]][j]){
                    diffCount++;
                    if(diffCount > P)   return false;
                }
            }
        }
        return true;
    }
}
