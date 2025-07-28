package programmers.stackQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class P42587_2 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int len = priorities.length;
        for(int i = 0; i < len; i++){
            pq.offer(priorities[i]);
        }
        while(!pq.isEmpty()){
            for(int i = 0; i < len; i++){
                if(priorities[i] == pq.peek()){
                    pq.poll();
                    answer++;
                    if(i == location) return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
