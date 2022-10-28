package baekjoon.boj20207;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20207 {
    static int N;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj20207/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] count = new int[367];
        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            for(int i = S; i <= E; i++){
                count[i]++;
            }
        }

        int h = 0, w = 0, sum = 0;
        for(int i = 1; i < 367; i++){
            if(count[i] == 0){
                sum += h*w;
                h = 0;
                w = 0;
            }
            else{
                w++;
                h = Math.max(h, count[i]);
            }
        }
        System.out.println(sum);

    }
}
