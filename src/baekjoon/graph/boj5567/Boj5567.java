package baekjoon.graph.boj5567;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj5567 {
    public static int n, m;
    public static ArrayList<Integer>[] arrayList;
    public static int[] visited;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj5567/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arrayList = new ArrayList[n + 1];
        visited = new int[n + 1];

        for(int i = 1; i < n + 1; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList[a].add(b);
            arrayList[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = 1;

        int count = 0;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int value : arrayList[now]){
                if(visited[value] != 0) continue;
                visited[value] = visited[now] + 1;
                if(visited[value] <= 3) count++;
                queue.offer(value);
            }
        }

        System.out.println(count);

    }
}
