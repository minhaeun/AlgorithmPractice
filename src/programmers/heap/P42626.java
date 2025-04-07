package programmers.heap;

import java.util.PriorityQueue;

public class P42626 {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int value : scoville) {
            pq.offer(value);
        }

        while(pq.size() > 1) {
            if(pq.peek() >= K) break;
            int value1 = pq.poll();
            int value2 = pq.poll();

            pq.offer(value1 + (value2 * 2));
            answer++;
        }
        int min = pq.poll();
        if(min < K) return -1;
        return answer;
    }
    public static void main(String[] args) {
        int scoville[] = {1, 2, 3, 9, 10, 12}, K = 7;

        System.out.println(solution(scoville, K));

    }
}
