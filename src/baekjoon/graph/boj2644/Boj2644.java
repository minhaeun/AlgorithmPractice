package baekjoon.graph.boj2644;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj2644 {
    public static int N, M, start, end, ans = -1;
    public static ArrayList<Integer>[] arrayList;
    public static boolean visited[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj2644/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arrayList = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arrayList[x].add(y);
            arrayList[y].add(x);
        }

        dfs(start, 0);
        System.out.println(ans);
    }

    public static void dfs(int start, int count){
        if(start == end){
            ans = count;
            return;
        }

        for(int value : arrayList[start]){
            if(visited[value])  continue;
            visited[value] = true;
            dfs(value, count + 1);
            visited[value] = false;
        }
    }
}
