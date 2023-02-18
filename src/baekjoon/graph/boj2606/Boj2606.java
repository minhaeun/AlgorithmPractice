package baekjoon.graph.boj2606;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj2606 {
    public static int N, M, count = 0;
    public static boolean visited[];
    public static ArrayList<Integer>[] arrayList;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj2606/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        arrayList = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arrayList[s].add(e);
            arrayList[e].add(s);
        }

        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int start){

        visited[start] = true;
        for(int value : arrayList[start]){
            if(!visited[value]){
                dfs(value);
                count++;
            }
        }

    }
}
