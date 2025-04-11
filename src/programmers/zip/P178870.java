package programmers.zip;

import java.util.Arrays;

public class P178870 {
    public static int[] solution(int[] sequence, int k) {

        int len = sequence.length;
        int minLen = len;
        int minLeft = len - 1, minRight = len - 1;
        int left = 0, right = 0;
        int sum = 0;
        while(right <= len){
            if(sum > k){
                sum -= sequence[left];
                left++;
            }
            else if(sum < k){
                if(right == len) break;
                sum += sequence[right];
                right++;
            }
            if(sum == k){
                int diff = right - left;
                if(diff < minLen){
                    minLen = diff;
                    minLeft = left;
                    minRight = right;
                }else if(diff == minLen){
                    if(left < minLeft){
                        minLeft = left;
                        minRight = right;
                    }
                }
                sum -= sequence[left];
                left++;
            }
        }

        return new int[]{minLeft, minRight - 1};
    }
    public static void main(String[] args) {
        int sequence1[] = {1, 2, 3, 4, 5}, k1 = 7;
        int sequence2[] = {1, 1, 1, 2, 3, 4, 5}, k2 = 5;
        int sequence3[] = {2, 2, 2, 2, 2}, k3 = 6;

        System.out.println(Arrays.toString(solution(sequence1, k1)));
        System.out.println(Arrays.toString(solution(sequence2, k2)));
        System.out.println(Arrays.toString(solution(sequence3, k3)));

    }
}
