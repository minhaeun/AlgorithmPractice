package programmers.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class P42583 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int sum = 0, time = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int truck : truck_weights) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.offer(truck);
                    sum += truck;
                    time++;
                    break;
                } else if (queue.size() == bridge_length) sum -= queue.poll();
                else {
                    if (sum + truck <= weight) {
                        queue.offer(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {
                        queue.offer(0);
                        time++;
                    }
                }
            }
        }
        return time + bridge_length;
    }
    public static void main(String[] args) {
        int bridge_length1 = 2, weight1 = 10, truck_weights1[] = {7,4,5,6};
        int bridge_length2 = 100, weight2 = 100, truck_weights2[] = {10};
        int bridge_length3 = 100, weight3 = 100, truck_weights3[] = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(solution(bridge_length1, weight1, truck_weights1));
        System.out.println(solution(bridge_length2, weight2, truck_weights2));
        System.out.println(solution(bridge_length3, weight3, truck_weights3));
    }
}
