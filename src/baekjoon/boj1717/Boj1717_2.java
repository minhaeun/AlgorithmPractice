package baekjoon.boj1717;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1717_2 {
    public static int[] parents;
    public static class Node{
        int num, parent;
        public Node(int num){
            this.num = num;
            this.parent = num;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1717/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        for(int i = 0; i < n + 1; i++){
            parents[i] = i;
        }

        Node[] arr = new Node[n + 1];
        for(int i = 0; i < n + 1; i++){
            arr[i] = new Node(i);
        }


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(flag == 0){
                union(a, b);
            }else{
                if(a == b)  sb.append("YES\n");
                else{
                    if(find(a) == find(b))    sb.append("YES\n");
                    else sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
    }
    public static int find(int a){
        if(parents[a] == a) return a;
        parents[a] = find(parents[a]);
        return parents[a];
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b) {
            if(a < b)   parents[b] = a;
            else parents[a] = b;
        }
    }
}
