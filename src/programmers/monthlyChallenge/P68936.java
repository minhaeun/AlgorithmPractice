package programmers.monthlyChallenge;

import java.util.Arrays;

public class P68936 {
    public static int[] answer;
    public static int[] solution(int[][] arr) {
        answer = new int[2];
        int len = arr.length;

        divide(0, 0, len, arr);

        return answer;
    }

    public static void divide(int r, int c, int len, int[][] arr){
        int result = check(r, c, len, arr);
        if(result >= 0){
            answer[result]++;
            return;
        }

        len /= 2;
        divide(r, c, len, arr);
        divide(r, c + len, len, arr);
        divide(r + len, c, len, arr);
        divide(r + len, c + len, len, arr);

    }

    public static int check(int r, int c, int len, int[][] arr){
        int value = arr[r][c];
        if(len == 1) return value;
        for(int i = r; i < r + len; i++){
            for(int j = c; j < c + len; j++){
                if(arr[i][j] != value) return -1;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[][] arr2 = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};

        System.out.println(Arrays.toString(solution(arr1)));
        System.out.println(Arrays.toString(solution(arr2)));

    }
}
