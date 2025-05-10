package programmers.pccp;

import java.util.Arrays;

public class P340212_2 {
    public static int solution(int[] diffs, int[] times, long limit) {
        int len = diffs.length;

        int low = 1, high = Arrays.stream(diffs).max().getAsInt();
        while (low <= high) {
            long time = 0;
            int mid = (low + high) / 2, prev = 0;
            for(int i = 0; i < len; i++){
                if(diffs[i] <= mid) time += times[i];
                else{
                    int wrong = diffs[i] - mid;
                    time += (long) (times[i] + prev) * wrong + times[i];
                }
                prev = times[i];
            }
            if(time > limit){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int diffs1[] = {1, 5, 3}, times1[] = {2, 4, 7}; long limit1 = 30;
        int diffs2[] = {1, 4, 4, 2}, times2[] = {6, 3, 8, 2}; long limit2 = 59;
        int diffs3[] = {1, 328, 467, 209, 54}, times3[] = {2, 7, 1, 4, 3}; long limit3 = 1723;
        int diffs4[] = {1, 99999, 100000, 99995}, times4[] = {9999, 9001, 9999, 9001}; long limit4 = 3456789012l;

        System.out.println(solution(diffs1, times1, limit1));
        System.out.println(solution(diffs2, times2, limit2));
        System.out.println(solution(diffs3, times3, limit3));
        System.out.println(solution(diffs4, times4, limit4));

    }
}
