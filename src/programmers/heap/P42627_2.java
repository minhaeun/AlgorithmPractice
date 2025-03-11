package programmers.heap;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P42627_2 {
    public static int solution(int[][] jobs) {
        int answer = 0;

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int len = jobs.length;

        int time = 0, idx = 0, count = 0;
        while(count < len){
            while(idx < len && jobs[idx][0] <= time) pq.offer(jobs[idx++]);
            if(pq.isEmpty()) time = jobs[idx][0];
            else{
                int[] now = pq.poll();
                answer += now[1] + time - now[0];
                time += now[1];
                count++;
            }
        }
        return answer / len;
    }
    public static void main(String[] args) {
        int[][] jobs1 = {{0, 3}, {1, 9}, {3, 5}};
        int[][] jobs2 = {{0, 3}, {1, 9}, {2, 6}};
        int[][] jobs3 = {{5, 10}, {6, 8}, {14, 2}, {11, 5}, {100, 7}};
        // System.out.println(solution(jobs1));
        // System.out.println(solution(jobs2));
        System.out.println(solution(jobs3));
    }
}
