package programmers.zip;

import java.util.Arrays;
import java.util.Comparator;

public class P181188 {
    public static int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int pos = 0;
        for(int i = 0; i < targets.length; i++){
            if(targets[i][0] < pos) continue;
            pos = targets[i][1];
            answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        int targets1[][] = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};

        System.out.println(solution(targets1));
    }
}
