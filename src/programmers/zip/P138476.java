package programmers.zip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P138476 {
    public static int solution(int k, int[] tangerine) {
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int value : tangerine){
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        Collections.reverse(list);

        for(int value : list){
            k -= value;
            answer++;
            if(k <= 0) break;
        }

        return answer;
    }
    public static void main(String[] args) {
        int k1 = 6, tangerine1[] = {1, 3, 2, 5, 4, 5, 2, 3};
        int k2 = 4, tangerine2[] = {1, 3, 2, 5, 4, 5, 2, 3};
        int k3 = 2, tangerine3[] = {1, 1, 1, 1, 2, 2, 2, 3};

        System.out.println(solution(k1, tangerine1));
        System.out.println(solution(k2, tangerine2));
        System.out.println(solution(k3, tangerine3));

    }
}
