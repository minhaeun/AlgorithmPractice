package programmers.zip;

import java.util.Arrays;

public class P12946 {
    public static int count, answer[][];
    public static int[][] solution(int n) {
        int size = (int)Math.pow(2, n) - 1;
        count = 0;
        answer = new int[size][2];

        dfs(n, 1, 3, 2);

        return answer;
    }

    public static void dfs(int n, int start, int end, int mid){
        if(n == 1){
            answer[count][0] = start;
            answer[count][1] = end;
            count++;
            return;
        }

        dfs(n - 1, start, mid, end);

        answer[count][0] = start;
        answer[count][1] = end;
        count++;

        dfs(n - 1, mid, end, start);

    }
    public static void main(String[] args) {
        int n = 2;
        System.out.println(Arrays.deepToString(solution(n)));
    }
}
