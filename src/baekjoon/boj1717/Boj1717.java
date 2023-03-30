package baekjoon.boj1717;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOError;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1717 {
    public static int[] parent;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1717/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int question = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(question == 0){
                union(a, b);
            }else{
                if(checkSame(a, b)){
                    sb.append("YES").append("\n");
                }else{
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);

    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }

    public static int find(int a){
        if(a == parent[a]){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }

    public static boolean checkSame(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b){
            return true;
        }else return false;
    }
}
