package programmers.devMatching2021;


import java.util.Arrays;

public class P1 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0, 0};

        int count = 0, best = 0, worst = 0;
        Arrays.sort(lottos);
        for(int i = 0; i < 6; i++){
            if(lottos[i] != 0) break;
            count++;
        }

        Arrays.sort(win_nums);
        for(int i = 0; i < 6; i++){
            for(int j = count; j < 6; j++){
                if(win_nums[i] != lottos[j])    continue;
                answer[0]++;
                answer[1]++;
            }
        }

        answer[0] += count;

        for(int i = 0; i < 2; i++){
            if(answer[i] == 6) answer[i] = 1;
            else if(answer[i] == 5) answer[i] = 2;
            else if(answer[i] == 4) answer[i] = 3;
            else if(answer[i] == 3) answer[i] = 4;
            else if(answer[i] == 2) answer[i] = 5;
            else answer[i] = 6;
        }

        return answer;
    }




}
