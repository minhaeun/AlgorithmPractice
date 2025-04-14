package programmers.stackQueue;

import java.util.Arrays;

public class P42584 {
    public static int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                answer[i]++;
                if(prices[i] > prices[j]) break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] prices1 = {1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(solution(prices1)));
    }
}
