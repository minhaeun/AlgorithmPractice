package programmers.zip;

import java.util.Arrays;

public class P12941 {
    public static int solution(int []A, int []B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int len = A.length;
        for(int i = 0; i < len; i++){
            answer += A[i] * B[len - i - 1];
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] A1 = {1, 4, 2}, B1 = {5, 4, 4};
        int[] A2 = {1, 2}, B2 = {3, 4};

        System.out.println(solution(A1, B1));
        System.out.println(solution(A2, B2));
    }
}
