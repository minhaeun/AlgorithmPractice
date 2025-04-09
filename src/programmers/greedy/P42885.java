package programmers.greedy;

import java.util.Arrays;

public class P42885 {
    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int len = people.length;
        int left = 0, right = len - 1;
        while(left <= right){
            if(people[left] + people[right] <= limit){
                left++;
            }
            right--;
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int people1[] = {70, 50, 80, 50}, limit1 = 100;
        int people2[] = {70, 80, 50}, limit2 = 100;

        System.out.println(solution(people1, limit1));
        System.out.println(solution(people2, limit2));
    }
}
