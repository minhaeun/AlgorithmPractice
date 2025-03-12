package programmers.zip;

import java.util.Arrays;

public class P12938 {
    public static int[] solution(int n, int s) {
        int[] answer = new int[n];

        if(n > s) return new int[]{-1};

        int num = s / n;
        int remainder = s % n;

        for(int i = 0; i < n; i++){
            answer[i] = num;
        }
        if(remainder == 0) return answer;
        for(int i = n - 1; i > 0; i--){
            if(remainder-- > 0) answer[i]++;
        }

        return answer;
    }
    public static void main(String[] args) {
        int n1 = 2, s1 = 9;
        int n2 = 2, s2 = 1;
        int n3 = 2, s3 = 8;

        System.out.println(Arrays.toString(solution(n1, s1)));
        System.out.println(Arrays.toString(solution(n2, s2)));
        System.out.println(Arrays.toString(solution(n3, s3)));
    }
}
