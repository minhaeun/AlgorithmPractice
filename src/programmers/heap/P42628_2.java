package programmers.heap;

import java.util.*;

public class P42628_2 {
    public static PriorityQueue<Integer> queue1;
    public static PriorityQueue<Integer> queue2;
    public static int[] solution(String[] operations) {
        int[] answer = {0, 0};

        StringTokenizer st;
        queue1 = new PriorityQueue<>();
        queue2 = new PriorityQueue<>(Collections.reverseOrder());

        for(String operation : operations) {
            st = new StringTokenizer(operation);
            char op = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if(op == 'I'){
                queue1.offer(num);
                queue2.offer(num);
            }
            if(op == 'D'){
                if(queue1.isEmpty()) continue;
                if(num == 1){
                    int max = queue2.poll();
                    queue1.remove(max);
                }
                else{
                    int min = queue1.poll();
                    queue2.remove(min);
                }
            }
        }
        if(!queue1.isEmpty()){
            answer[0] = queue2.poll();
            answer[1] = queue1.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] operations1 = {"I 16","D 1"};
        String[] operations2 = {"I 7","I 5","I -5","D -1"};
        System.out.println(Arrays.toString(solution(operations1)));
        System.out.println(Arrays.toString(solution(operations2)));
    }
}
