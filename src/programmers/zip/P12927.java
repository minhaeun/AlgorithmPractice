package programmers.zip;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P12927 {
    public static long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int work : works) {
            pq.offer(work);
        }
        while(n > 0){
            int work = pq.poll();
            if(work == 0) break;
            work--;
            pq.offer(work);
            n--;
        }
        for(int work : pq){
            answer += work * work;
        }
        return answer;
    }
    public static void main(String[] args) {
        int works1[] = {4, 3, 3}, n1 = 4;
        int works2[] = {2, 1, 2}, n2 = 1;
        int works3[] = {1, 1}, n3 = 3;

        System.out.println(solution(n1, works1));
        System.out.println(solution(n2, works2));
        System.out.println(solution(n3, works3));
    }
}
