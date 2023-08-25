package baekjoon.boj13305;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13305 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj13305/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        long[] costs = new long[N - 1];
        long[] dists = new long[N - 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N - 1; i++)  dists[i] = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N - 1; i++)  costs[i] = Long.parseLong(st.nextToken());

        long minCost = costs[0];
        long result = 0;
        for(int i = 0; i < N - 1; i++){
            if(minCost > costs[i]){
                minCost = costs[i];
            }
            result += (minCost * dists[i]);
        }
        System.out.println(result);

    }
}
