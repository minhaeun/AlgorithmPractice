package programmers.stackQueue;

import java.util.Arrays;
import java.util.Stack;

public class P42584_2 {
    public static int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] prices1 = {1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(solution(prices1)));
    }
}
