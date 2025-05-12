package programmers.stackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P42586 {
    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        int len = progresses.length;
        for(int i = 0; i < len; i++){
            int value = (int)Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            System.out.println(value);
            queue.offer(value);
        }
        int before = queue.poll();
        int count = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(before >= now){
                count++;
            }
            else{
                list.add(count);
                count = 1;
                before = now;
            }

        }
        list.add(count);
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] progresses1 = {93, 30, 55}, speeds1 = {1, 30, 5};
        int[] progresses2 = {95, 90, 99, 99, 80, 99}, speeds2 = {1, 1, 1, 1, 1, 1};
        int[] progresses3 = {85, 80, 90, 85}, speeds3 = {5, 5, 5, 5};

        System.out.println(Arrays.toString(solution(progresses1, speeds1)));
        System.out.println(Arrays.toString(solution(progresses2, speeds2)));
        System.out.println(Arrays.toString(solution(progresses3, speeds3)));
    }
}
