package baekjoon.graph.boj13023;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj13023 {
    public static int N, M;
    public static boolean visited[];
    public static boolean arrive;
    public static ArrayList<Integer> arrayList[];

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj13023/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arrayList = new ArrayList[N];

        for(int i = 0; i < N; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList[a].add(b);
            arrayList[b].add(a);

        }

        for(int i = 0; i < N; i++){
            dfs(i, 1);
            if(arrive)  break;
        }
        if(arrive) System.out.println(1);
        else System.out.println(0);


    }

    public static void dfs(int start, int count){
        if(arrive || count == 5){
            arrive = true;
            return;
        }

        visited[start] = true;
        for(int value : arrayList[start]){
            if(!visited[value]){
                dfs(value, count + 1);
            }
        }
        visited[start] = false;

    }
}
