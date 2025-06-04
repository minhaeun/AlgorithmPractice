package programmers.bruteForce;

import java.util.Arrays;

public class P42842 {
    public static int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown + yellow;
        if(yellow == 1) return new int[]{(int) Math.sqrt(sum), (int) Math.sqrt(sum)};
        for(int i = 2; i <= sum; i++){
            if(yellow % i == 0){
                int r = yellow / i;
                int c = i;
                if(r == 1){
                    r = c;
                    c = 1;
                }

                int br = r + 2;
                int bc = c + 2;

                int b = br * bc - yellow;
                if(b == brown) return new int[] {br, bc};
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int brown1 = 10, yellow1 = 2;
        int brown2 = 8, yellow2 = 1;
        int brown3 = 24, yellow3 = 24;

        System.out.println(Arrays.toString(solution(brown1, yellow1)));
        System.out.println(Arrays.toString(solution(brown2, yellow2)));
        System.out.println(Arrays.toString(solution(brown3, yellow3)));
    }
}
