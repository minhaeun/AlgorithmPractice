package programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P42627 {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int current = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int idx = 0;
        while(true){
            if(idx == jobs.length && pq.isEmpty())  break;
            if(pq.isEmpty() && jobs[idx][0] > current) current = jobs[idx][0];
            for(int i = idx; i < jobs.length; i++){
                if(jobs[i][0] <= current){
                    pq.offer(jobs[i]);
                    idx ++;
                }
                else break;
            }
            if(!pq.isEmpty()){
                int[] value = pq.poll();
                int reqTime = value[0];
                int taskTime = value[1];

                answer += current + taskTime - reqTime;
                current += taskTime;
            }
        }
        return answer / jobs.length;
    }
}
