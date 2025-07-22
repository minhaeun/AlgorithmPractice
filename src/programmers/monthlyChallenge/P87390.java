package programmers.monthlyChallenge;

import java.util.Arrays;

public class P87390 {
    public static int[] solution(int n, long left, long right) {
        int len = Math.toIntExact(right - left + 1);
        int[] answer = new int[len];

        int index = 0;
        while(left <= right){
            int quotient = Math.toIntExact(left / n);
            int remainder = Math.toIntExact(left % n);
            int max = Math.max(quotient, remainder);
            answer[index++] = max + 1;
            left++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n1 = 3, left1 = 2, right1 = 5;
        int n2 = 4, left2 = 7, right2 = 14;

        System.out.println(Arrays.toString(solution(n1, left1, right1)));
        System.out.println(Arrays.toString(solution(n2, left2, right2)));
    }

}
