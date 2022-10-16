package baekjoon.boj1325;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1325 {
    static int N, M, count[];
    static ArrayList<Integer>[] arrayList;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1325/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList[N+1];
        count = new int[N+1];

        for(int i = 1; i <=N; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList[a].add(b);
        }

        for(int i = 1; i < N+1; i++){
            bfs(i);
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N+1; i++){
            max = Math.max(count[i], max);
        }

        for(int i = 0; i < N+1; i++){
            if(count[i] == max){
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb.toString().trim());

    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N+1];
        queue.add(start);
        visit[start] = true;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : arrayList[cur]){
                if(visit[next]) continue;
                count[next]++;
                visit[next] = true;
                queue.offer(next);
            }
        }
    }

}
