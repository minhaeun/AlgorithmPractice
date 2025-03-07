package programmers.binarySearch;

import java.util.Arrays;

public class P43238 {
    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        int len = times.length;
        long high = (long) times[len - 1] * n;
        long low = 0;
        while(low <= high){
            long mid = (low + high) / 2;
            long sum = 0;
            for(int time : times){
                sum += mid / time;
            }
            if(sum >= n){
                answer = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int n1 = 6, times1[] = {7, 10};

        System.out.println(solution(n1, times1));

    }
}
