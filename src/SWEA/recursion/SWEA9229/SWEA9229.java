package SWEA.recursion.SWEA9229;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA9229 {
    static int N;
    static int M;
    static int max;
    static int[] snack;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("SWEA/recursion/SWEA9229/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = null;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            snack = new int[N];
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++){
                snack[i] = Integer.parseInt(st.nextToken());
            }
            max = -1;
            calculate( 0,0,  0);
            sb.append("#").append(tc).append(" ").append(max);
            System.out.println(sb);
        }
    }

    static void calculate(int count, int idx, int weight){
        if(weight > M)  return;

        if(count == 2){
            if(weight > max)    max = weight;
            return;
        }

        if(idx == N)    return;

        // 현재 원소 비선택
        calculate(count, idx + 1,  weight);
        // 현재 원소 선택
        calculate(count + 1, idx + 1,  weight + snack[idx]);

    }
}
