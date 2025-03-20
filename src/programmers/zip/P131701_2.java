package programmers.zip;

import java.util.HashSet;

public class P131701_2 {
    public static int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();

        int sum = 0;
        int len = elements.length;

        for(int i = 0; i < len; i++){
            sum += elements[i];
            set.add(sum);
            int tmp = sum;
            for(int j = 1; j < len; j++){
                tmp -= elements[j - 1];
                tmp += elements[(i + j) % len];
                set.add(tmp);
            }
        }
        return set.size();
    }
    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};

        System.out.println(solution(elements));
    }
}
