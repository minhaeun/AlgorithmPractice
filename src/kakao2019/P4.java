package kakao2019;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class P4 {
    public static void main(String[] args) {
        int[] food_times = {3, 1, 2};
        long k = 5;

        System.out.println(solution(food_times, k));

    }

    public static int solution(int[] food_times, long k) {
        int answer = -1;
        PriorityQueue<Food> pq = new PriorityQueue<>(new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.time - o2.time;
            }
        });

        int len = food_times.length;
        for (int i = 0; i < len; i++) {
            pq.offer(new Food(i + 1, food_times[i]));
        }
        int pre = 0;
        while (!pq.isEmpty()) {
            int size = pq.size();
            int v = pq.peek().time - pre;
            if (size * v > k) {
                PriorityQueue<Food> queue = new PriorityQueue<>(new Comparator<Food>() {
                    @Override
                    public int compare(Food o1, Food o2) {
                        return o1.index - o2.index;
                    }
                });

                for(int i = 0; i < size; i++){
                    queue.offer(pq.poll());
                }
                int tmpIndex = (int) (k % size) + 1;
                while(tmpIndex-- > 0){
                    answer = queue.poll().index;
                }
                break;
            }
            k -= size * v;
            pre = pq.poll().time;


        }
        return answer;
    }

    public static class Food {
        int index, time;

        Food(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

}
