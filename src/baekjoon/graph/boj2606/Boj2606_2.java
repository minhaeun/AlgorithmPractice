package baekjoon.graph.boj2606;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2606_2 {
    public static int N, M, count;
    public static boolean visited[];
    public static ArrayList<Integer> arrayList[];
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj2606/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        arrayList = new ArrayList[N + 1];

        for(int i = 1; i < N + 1; i++){
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arrayList[s].add(e);
            arrayList[e].add(s);
        }

        bfs(1);

        System.out.println(count);
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int value : arrayList[now]){
                if(visited[value])  continue;
                queue.offer(value);
                visited[value] = true;
                count++;
            }
        }
    }
}
