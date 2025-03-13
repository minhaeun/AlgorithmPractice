package programmers.zip;

import java.util.Arrays;
import java.util.HashMap;

public class P152996 {
    public static long solution(int[] weights) {
        long answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int weight : weights){
            map.put(weight, map.getOrDefault(weight, 0) + 1);
        }

        for(int weight : map.keySet()){
            int count = map.get(weight);
            if(count > 1){
                answer += (long) count * (count - 1) / 2;
            }

            int[] ratios = {2, 3, 4};
            for(int r1 : ratios){
                for(int r2 : ratios){
                    if(r1 >= r2) continue;
                    int target = (weight * r2) / r1;
                    if((weight * r2) % r1 != 0) continue;
                    if(map.containsKey(target)){
                        answer += (long) map.get(weight) * map.get(target);
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] weights1 = {100,180,360,100,270};
        int[] weights2 = {10, 10, 20, 20};

        System.out.println(solution(weights2));

    }
}
