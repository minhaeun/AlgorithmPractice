package programmers.zip;

import java.util.Arrays;

public class P12949 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int lenR = arr1.length;
        int lenC = arr2[0].length;
        int len = arr1[0].length;

        int[][] answer = new int[lenR][lenC];

        for(int i = 0; i < lenR; i++){
            for(int j = 0; j < lenC; j++){
                int value = 0;
                for(int k = 0; k < len; k++){
                    value += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = value;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[][] arr11 = {{1, 4}, {3, 2}, {4, 1}}, arr12 = {{3, 3}, {3, 3}};
        int[][] arr21 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, arr22 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
        int[][] arr31 = {{1, 2}, {2, 1}}, arr32 = {{1, 1, 1, 1}, {2, 2, 2, 2}};
        int[][] arr41 = {{1, 2, 3}, {3, 2, 1}}, arr42 = {{1, 2}, {2, 1}, {1, 2}};

        System.out.println(Arrays.deepToString(solution(arr11, arr12)));
        System.out.println(Arrays.deepToString(solution(arr21, arr22)));
        System.out.println(Arrays.deepToString(solution(arr31, arr32)));
        System.out.println(Arrays.deepToString(solution(arr41, arr42)));
    }
}
