package programmers.zip;

import java.util.Arrays;
import java.util.Stack;

public class P154539 {
    public static int[] solution(int[] numbers) {
        int len = numbers.length;
        int[] answer = new int[len];

        Stack<Integer> stack = new Stack<>();
        stack.push(numbers[len - 1]);
        answer[len - 1] = -1;

        for(int i = len - 2; i >= 0; i--){
            int value = numbers[i];
            if(numbers[i + 1] > value) answer[i] = numbers[i + 1];
            else{
                while(!stack.isEmpty() && stack.peek() <= value){
                    stack.pop();
                }
                answer[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(value);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] numbers1 = {6, 3, 4, 2};
        int[] numbers2 = {3, 6, 9, 1, 5, 3, 6, 2};
        int[] numbers3 = {8, 1, 2, 9};

        System.out.println(Arrays.toString(solution(numbers1)));
        System.out.println(Arrays.toString(solution(numbers2)));
        System.out.println(Arrays.toString(solution(numbers3)));
    }
}
