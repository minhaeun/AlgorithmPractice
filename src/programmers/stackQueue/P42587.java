package programmers.stackQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P42587 {
    public static class Process{
        int index, num;
        public Process(int index, int num){
            this.index = index;
            this.num = num;
        }
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Process> queue = new LinkedList<>();
        int len = priorities.length;
        int[] sortedArr = Arrays.copyOf(priorities, len);
        Arrays.sort(sortedArr);
        for(int i = 0; i < len; i++){
            queue.offer(new Process(i, priorities[i]));
        }

        for(int i = 0; i < len; i++){
            int max = sortedArr[len - i - 1];
            int seq = 0;
            while(!queue.isEmpty()){
                Process process = queue.poll();
                if(process.num == max){
                    seq = process.index;
                    break;
                }
                queue.offer(process);
            }
            if(seq == location){
                answer = i + 1;
                break;
            }
        }

        return answer;
    }
    public static void main(String[] args) {

    }
}
