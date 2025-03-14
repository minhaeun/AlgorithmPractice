package programmers.zip;

import java.util.ArrayList;
import java.util.Arrays;

public class P12936 {
    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();

        long total = 1;
        for(int i = 1; i <= n; i++){
            list.add(i);
            total *= i;
        }

        k--;
        int idx = 0;
        while(idx < n){
            total /= n - idx;
            answer[idx++] = list.remove((int) (k / total));
            k %= total;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n1 = 3, k1 = 5;

        System.out.println(Arrays.toString(solution(n1, k1)));
    }
}
