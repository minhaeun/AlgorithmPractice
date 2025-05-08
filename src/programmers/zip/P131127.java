package programmers.zip;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class P131127 {
    public static HashMap<String, Integer> stdMap, countMap;
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Queue<String> queue = new LinkedList<>();
        int disLen = discount.length;
        int wantLen = want.length;
        stdMap = new HashMap<>();
        countMap = new HashMap<>();
        for(int i = 0; i < wantLen; i++){
            stdMap.put(want[i], number[i]);
        }
        for(int i = 0; i < 10; i++){
            String str = discount[i];
            queue.offer(str);
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }

        if(check()) answer++;

        for(int i = 10; i < disLen; i++){
            String value = queue.poll();
            countMap.put(value, countMap.getOrDefault(value, 0) - 1);
            String newValue = discount[i];
            queue.offer(newValue);
            countMap.put(newValue, countMap.getOrDefault(newValue, 0) + 1);
            if(check()) answer++;
        }

        return answer;
    }
    public static boolean check(){
        for(String str : countMap.keySet()){
            if(countMap.get(str) == 0) continue;
            if(!countMap.get(str).equals(stdMap.get(str))) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String[] want1 = {"banana", "apple", "rice", "pork", "pot"}, discount1 = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}; int[] number1 = {3, 2, 2, 2, 1};
        String[] want2 = {"apple"}, discount2 = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}; int[] number2 = {10};

        System.out.println(solution(want1, number1, discount1));
        System.out.println(solution(want2, number2, discount2));
    }
}
