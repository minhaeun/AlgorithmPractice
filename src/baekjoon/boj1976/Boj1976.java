package baekjoon.boj1976;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1976 {
    public static int[] parents;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1976/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        for(int i = 1; i <= N; i++){
            parents[i] = i;
        }

        int[][] map = new int[N + 1][N + 1];
        int[] des = new int[M];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1)    union(i, j);
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        int root = find(Integer.parseInt(st.nextToken()));
        for(int i = 1; i < M; i++){
            if(root != find(Integer.parseInt(st.nextToken()))){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    public static int find(int x){
        if(x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            if(x < y)   parents[y] = x;
            else parents[x] = y;
        }
    }
}
