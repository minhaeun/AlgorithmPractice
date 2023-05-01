package baekjoon.graph.boj5014;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj5014 {
    public static int F, S, G, U, D, ans;
    public static boolean visited[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj5014/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1];

        ans = bfs();

        if(ans >= 0) System.out.println(ans);
        else System.out.println("use the stairs");

    }
    public static int bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        visited[S] = true;

        int size = 0;
        int count = -1;
        while(!queue.isEmpty()){
            size = queue.size();
            count++;
            for(int step = 0; step < size; step++){
                int cur = queue.poll();
                if(cur == G)    return count;
                if(cur + U <= F && !visited[cur + U]){
                    queue.offer(cur + U);
                    visited[cur + U] = true;
                }
                if(cur - D > 0 && !visited[cur - D]){
                    queue.offer(cur - D);
                    visited[cur - D] = true;
                }
            }
        }
        return -1;
    }
}
