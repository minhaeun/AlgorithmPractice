package programmers.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P49189 {
    public static int[] arr;
    public static boolean[] visited;
    public static ArrayList<Integer>[] list;
    public static int solution(int n, int[][] edge) {
        int answer = 0;

        list = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++){
            list[i] = new ArrayList<>();
        }

        int len = edge.length;
        for(int i = 0; i < len; i++){
            int s = edge[i][0];
            int e = edge[i][1];
            list[s].add(e);
            list[e].add(s);
        }

        arr = new int[n + 1];
        visited = new boolean[n + 1];
        visited[1] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int value : list[now]){
                if(visited[value]) continue;
                visited[value] = true;
                arr[value] = arr[now] + 1;
                queue.offer(value);
            }
        }

        int max = Arrays.stream(arr).max().getAsInt();
        for(int value : arr){
            if(max == value) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n1 = 6, vertex1[][] = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(solution(n1, vertex1));

    }
}
