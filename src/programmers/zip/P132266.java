package programmers.zip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P132266 {
    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        int[] cost = new int[n + 1];

        for(int i = 0; i < n + 1; i++){
            list[i] = new ArrayList<>();
            cost[i] = Integer.MAX_VALUE;
        }

        for(int[] road : roads){
            list[road[0]].add(road[1]);
            list[road[1]].add(road[0]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        cost[destination] = 0;
        pq.offer(destination);
        while(!pq.isEmpty()){
            int now = pq.poll();

            int len = list[now].size();
            for(int i = 0; i < len; i++){
                int next = list[now].get(i);
                if(cost[next] > cost[now] + 1){
                    cost[next] = cost[now] + 1;
                    pq.offer(next);
                }
            }
        }
        for(int i = 0; i < sources.length; i++){
            answer[i] = cost[sources[i]] < Integer.MAX_VALUE ? cost[sources[i]] : -1;
        }
        return answer;
    }
    public static void main(String[] args) {
        int n1 = 3, roads1[][] = {{1, 2}, {2, 3}}, sources1[] = {2, 3}, destination1 = 1;
        int n2 = 5, roads2[][] = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}}, sources2[] = {1, 3, 5}, destination2 = 5;

        System.out.println(Arrays.toString(solution(n1, roads1, sources1, destination1)));
        System.out.println(Arrays.toString(solution(n2, roads2, sources2, destination2)));
    }
}
