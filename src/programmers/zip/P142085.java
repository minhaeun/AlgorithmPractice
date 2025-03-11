package programmers.zip;

import java.util.Collections;
import java.util.PriorityQueue;

public class P142085 {
    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < enemy.length; i++){
            n -= enemy[i];
            pq.add(enemy[i]);

            if(n < 0){
                if(k > 0){
                    n += pq.poll();
                    k--;
                }else break;
            }
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int n1 = 7, k1 = 3, enemy1[] = {4, 2, 4, 5, 3, 3, 1};
        int n2 = 2, k2 = 4, enemy2[] = {3, 3, 3, 3};

        System.out.println(solution(n1, k1, enemy1));
        System.out.println(solution(n2, k2, enemy2));

    }
}
