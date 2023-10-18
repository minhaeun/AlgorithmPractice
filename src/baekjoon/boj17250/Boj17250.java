package baekjoon.boj17250;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj17250 {
    public static int N, M, parents[][];
    public static int find(int x){
        if(parents[1][x] < 0)   return x;
        return parents[1][x] = find(parents[1][x]);
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj17250/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[2][N + 1];
        Arrays.fill(parents[1], -1);


        for(int i = 1; i < N + 1; i++){
            parents[0][i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int r1 = find(s);
            int r2 = find(e);
            if(r1 == r2){
                sb.append(parents[0][r1]).append("\n");
                continue;
            }
            int root;
            if(parents[1][r1] < parents[1][r2]){
                parents[1][r1] += parents[1][r2];
                parents[1][r2] = r1;
                parents[0][r1] = parents[0][r1] + parents[0][r2];
                root = r1;
            }else{
                parents[1][r2] += parents[1][r1];
                parents[1][r1] = r2;
                parents[0][r2] = parents[0][r2] + parents[0][r1];
                root = r2;
            }
            sb.append(parents[0][root]).append("\n");
        }
        System.out.println(sb);


    }
}
