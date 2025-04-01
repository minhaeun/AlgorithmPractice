package programmers.zip;

import java.util.Arrays;
import java.util.Comparator;

public class P152995 {
    public static int solution(int[][] scores) {
        int answer = 0;
        int len = scores.length;
        int a = scores[0][0];
        int b = scores[0][1];

        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });

        int max = scores[0][1];

        for(int i = 1; i < len; i++){
            if(scores[i][1] < max){
                if(scores[i][0] == a && scores[i][1] == b) return -1;
                scores[i][0] = -1;
                scores[i][1] = -1;
            }else max = scores[i][1];

        }
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[0] + o2[1]) - (o1[0] + o1[1]);
            }
        });

        answer = 1;
        for(int i = 0; i < len; i++){
            if(scores[i][0] + scores[i][1] > a + b) answer++;
            else break;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] scores = {{2,2},{1,4},{3,2},{3,2},{2,1}};

        System.out.println(solution(scores));

    }
}
