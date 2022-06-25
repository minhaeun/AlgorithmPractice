package programmers.heap;

import java.util.*;

public class P42628 {
    static PriorityQueue<Integer> queue1;
    static PriorityQueue<Integer> queue2;

    public static void main(String[] args) {
        String[] operations1 = {"I 16","D 1"};
        String[] operations2 = {"I 7","I 5","I -5","D -1"};
        System.out.println(Arrays.toString(solution(operations1)));
        System.out.println(Arrays.toString(solution(operations2)));
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        StringTokenizer st;
        queue1 = new PriorityQueue<>();
        queue2 = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i < operations.length; i++){
            st = new StringTokenizer(operations[i], " ");
            String cmd = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(cmd.equals("D") && queue1.isEmpty()) continue;
            if(cmd.equals("I")){
                queue1.offer(num);
                queue2.offer(num);
            }else{
                if(num == 1){
                    int max = queue2.poll();
                    queue1.remove(max);
                }else{
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
}
