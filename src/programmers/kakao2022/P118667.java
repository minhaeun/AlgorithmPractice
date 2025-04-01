package programmers.kakao2022;

import java.util.Arrays;

public class P118667 {
    public static int solution(int[] queue1, int[] queue2) {

        long total1 = 0, total2 = 0;
        int len1 = queue1.length;
        int len2 = queue2.length;
        int len = len1 + len2;
        int[] arr = new int[len * 2];

        for(int i = 0; i < len1; i++) {
            arr[i] = queue1[i];
            arr[i + len] = queue1[i];
            total1 += queue1[i];
        }
        for(int i = 0; i < len2; i++) {
            arr[len1 + i] = queue2[i];
            arr[len1 + i + len] = queue2[i];
            total2 += queue2[i];
        }

        long half = (total1 + total2)/2;
        int start = 0, end = len1 - 1;

        long sum = total1;
        int count = 0;
        boolean flag = false;
        while(start < len * 2) {
            if(sum == half){
                flag = true;
                break;
            }
            else if(sum < half){
                end++;
                count++;
                if(end >= len * 2) break;
                sum += arr[end];
            }else{
                sum -= arr[start];
                start++;
                count++;
            }
        }

        if(flag) return count;
        return -1;
    }
    public static void main(String[] args) {
        int[] queue11 = {3, 2, 7, 2}, queue12 = {4, 6, 5, 1};
        int[] queue21 = {1, 2, 1, 2}, queue22 = {1, 10, 1, 2};
        int[] queue31 = {1, 1}, queue32 = {1, 5};
        int[] queue41 = {1, 10, 1, 2}, queue42 = {1, 2, 1, 2};

        System.out.println(solution(queue11, queue12));
        System.out.println(solution(queue21, queue22));
        System.out.println(solution(queue31, queue32));
        System.out.println(solution(queue41, queue42));

    }

}
