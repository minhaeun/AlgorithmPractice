package programmers.zip;

import java.util.Arrays;

public class P154539_2 {
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        for(int i = numbers.length - 2; i >= 0; i--){
            for(int j = i + 1; j < numbers.length; j++){
                if(numbers[i] < numbers[j]){
                    answer[i] = numbers[j];
                    break;
                }
                if(answer[j] == -1) break;
                if(numbers[i] < answer[j]){
                    answer[i] = answer[j];
                    break;
                }
            }
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
