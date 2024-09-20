package baekjoon.boj1976;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1976_2 {
    public static int N, M, parents[], arr[];
    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            if(x < y) parents[y] = x;
            else parents[x] = y;
        }
    }
    public static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1976/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());


        parents = new int[N + 1];
        arr = new int[N];

        for(int i = 1; i < N + 1; i++){
            parents[i] = i;
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 0) continue;
                union(i, j);
            }
        }



        st = new StringTokenizer(br.readLine(), " ");
        int root = find(Integer.parseInt(st.nextToken()));
        for(int i = 1; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(root != find(num)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");






    }
}
