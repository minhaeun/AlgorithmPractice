package programmers.zip;

import java.util.Arrays;

public class P12987 {
    public static int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int len = A.length;
        int index = -1;
        int count = 0;
        for(int i = 0; i < len; i++){
            for(int j = index + 1; j < len; j++){
                if(A[i] < B[j]){
                    index = j;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] A1 = {5,1,3,7}, B1 = {2,2,6,8};
        int[] A2 = {2,2,2,2}, B2 = {1,1,1,1};
        int[] A3 = {2,3,4,5,6,7}, B3 = {7,6,5,4,3,2};

        System.out.println(solution(A1, B1));
        System.out.println(solution(A2, B2));
        System.out.println(solution(A3, B3));
    }
}
