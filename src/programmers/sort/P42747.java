package programmers.sort;

import java.util.Arrays;

public class P42747 {
    public static int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        int n = citations.length;

        int low = 0, high = citations[n - 1], mid = 0;
        if(low == high) return 0;
        while(low <= high){
            mid = (low + high) / 2;
            if(n < mid){
                high = mid - 1;
                continue;
            }
            if(citations[n - mid] >= mid){
                answer = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] citations1 = {3, 0, 6, 1, 5};
        int[] citations2 = {0, 0, 0};
        System.out.println(solution(citations2));
    }
}
