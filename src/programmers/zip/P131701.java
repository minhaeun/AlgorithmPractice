package programmers.zip;

import java.util.HashSet;

public class P131701 {
    public static int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();

        int start = 1;
        int len = elements.length;

        while (start <= len) {
            for(int i = 0; i < len; i++){
                int sum = 0;
                for(int j = i; j < i + start; j++){
                    sum += elements[j % len];
                }
                set.add(sum);
            }
            start++;
        }
        return set.size();
    }
    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};

        System.out.println(solution(elements));
    }
}
