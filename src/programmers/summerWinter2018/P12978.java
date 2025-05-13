package programmers.summerWinter2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class P12978 {
    public static ArrayList<Node> list[];
    public static int[] arr;
    public static class Node{
        int e, weight;
        public Node(int e, int weight) {
            this.e = e;
            this.weight = weight;
        }
    }
    public static int solution(int N, int[][] road, int K) {
        int answer = 1;
        list = new ArrayList[N+1];
        arr = new int[N+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int len = road.length;
        for(int i = 0; i < len; i++){
            int s = road[i][0];
            int e = road[i][1];
            int w = road[i][2];
            list[s].add(new Node(e, w));
            list[e].add(new Node(s, w));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        arr[1] = 0;

        while(!pq.isEmpty()) {
            int now = pq.poll();
            int size = list[now].size();
            for(int i = 0; i < size; i++) {
                int next = list[now].get(i).e;
                int weight = list[now].get(i).weight;
                if(arr[next] <= arr[now] + weight) continue;
                arr[next] = arr[now] + weight;
                pq.offer(next);

            }
        }

        for(int i = 2; i <= N; i++){
            if(arr[i] <= K) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int N1 = 5, road1[][] = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, K1 = 3;
        int N2 = 6, road2[][] = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}, K2 = 4;

        System.out.println(solution(N1, road1, K1));
        System.out.println(solution(N2, road2, K2));

    }
}
