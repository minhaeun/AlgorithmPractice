package programmers.zip;

import java.util.Arrays;
import java.util.Comparator;

public class P147354 {
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int finalCol = col - 1;
        row_begin -= 1;

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[finalCol] == o2[finalCol]) return o2[0] - o1[0];
                return o1[finalCol] - o2[finalCol];
            }
        });

        for(int i = row_begin; i < row_end; i++) {
            int finalI = i + 1;
            int dataTotal = Arrays.stream(data[i]).map(x -> x % finalI).sum();
            answer ^= dataTotal;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
        int col = 2, row_begin = 2, row_end = 3;

        System.out.println(solution(data, col, row_begin, row_end));
    }
}
