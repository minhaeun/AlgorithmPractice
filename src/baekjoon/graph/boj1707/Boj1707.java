package baekjoon.graph.boj1707;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1707 {
    public static ArrayList<Integer>[] arrayList;
    public static boolean visited[], IsEven;
    public static int check[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj1707/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());

        for(int t = 1; t <= K; t++){
            st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            visited = new boolean[V + 1];
            check = new int[V + 1];
            IsEven = true;

            arrayList = new ArrayList[V + 1];
            for(int i = 1; i < V + 1; i++){
                arrayList[i] = new ArrayList<>();
            }

            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                arrayList[s].add(e);
                arrayList[e].add(s);
            }

            for(int i = 1; i < V + 1; i++){
                if(IsEven)  dfs(i);
                else    break;
            }

            if(IsEven) System.out.println("YES");
            else System.out.println("NO");

        }

    }

    public static void dfs(int start){
        visited[start] = true;

        for(int value : arrayList[start]){
            if(!visited[value]) {
                visited[value] = true;
                check[value] = (check[start] + 1) % 2;
                dfs(value);
            }else if (check[start] == check[value]){
                IsEven = false;
            }

        }


    }
}
