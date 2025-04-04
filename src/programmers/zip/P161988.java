package programmers.zip;

import java.util.Arrays;

public class P161988 {
    public static long solution(int[] sequence) {
        long answer = 0;
        boolean isPlus = true;
        long purse1 = 0;
        long purse2 = 0;
        for (int num : sequence) {
            purse1 += isPlus ? num : -num;
            purse2 += isPlus ? -num : num;
            purse1 = Math.max(0, purse1);
            purse2 = Math.max(0, purse2);
            answer = Math.max(answer, Math.max(purse1, purse2));
            isPlus = !isPlus;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] sequence1 = {2, 3, -6, 1, 3, -1, 2, 4};

        System.out.println(Arrays.toString(sequence1));

    }
}
