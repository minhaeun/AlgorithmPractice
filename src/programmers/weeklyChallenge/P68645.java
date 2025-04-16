package programmers.weeklyChallenge;

import java.util.Arrays;

public class P68645 {
    public static int[][] arr;
    public static int[] solution(int n) {
        arr = new int[n][];
        int len = 0;
        for(int i = 0; i < n; i++){
            arr[i] = new int[i + 1];
            len += arr[i].length;
        }
        int[] answer = new int[len];
        fill(n, 0, 0, 1);
        int index = 0;
        for(int i = 0; i < n; i++){
            for(int value : arr[i]){
                answer[index++] = value;
            }
        }
        return answer;
    }
    public static void fill(int n, int start, int count, int num) {
        if(n < 1) return;
        for(int i = start; i < start + n; i++){
            arr[i][count] = num++;
        }
        for(int i = count + 1; i < count + n; i++){
            arr[start + n - 1][i] = num++;
        }
        for(int i = start + n - 2; i > start; i--){
            arr[i][arr[i][0] - count - 1] = num++;
        }
        start += 2;
        fill(n - 3, start, count + 1, num);
    }
    public static void main(String[] args) {
        int n1 = 4;
        int n2 = 5;
        int n3 = 6;

//        System.out.println(Arrays.toString(solution(n1)));
//        System.out.println(Arrays.toString(solution(n2)));
        System.out.println(Arrays.toString(solution(n3)));
    }
}
