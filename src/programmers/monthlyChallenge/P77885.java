package programmers.monthlyChallenge;

import java.util.Arrays;

public class P77885 {
    public static long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        for (int i = 0; i < numbers.length; i++) {
            answer[i]++;
            answer[i] += (answer[i] ^ numbers[i]) >> 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        long[] numbers1 = {2, 7};

        System.out.println(Arrays.toString(solution(numbers1)));
    }
}
