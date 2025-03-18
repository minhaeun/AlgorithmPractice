package programmers.kakao2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class P67258 {
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        int len = gems.length;
        answer[0] = 1;
        answer[1] = len;
        HashSet<String> hashSet = new HashSet<>(List.of(gems));
        int total = hashSet.size();

        int left = 0, right = 0;
        HashMap<String, Integer> map = new HashMap<>();
        while(left < len){
            int size = map.size();
            if(size == total){
                int count = map.get(gems[left]);
                if(count > 1) map.put(gems[left], map.getOrDefault(gems[left], 0) - 1);
                else map.remove(gems[left]);
                left++;
            }else if(right == len) break;
            else{
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }
            if(size == total){
                int diff = answer[1] - answer[0];
                int std = right- left;
                if((diff > std) || ((diff == std) && (answer[0] > left))){
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
        String[] gems3 = {"XYZ", "XYZ", "XYZ"};
        String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        String[] gems5 = {"A","B","B","B","B","B","B","C","B","A"};

        System.out.println(Arrays.toString(solution(gems1)));
        System.out.println(Arrays.toString(solution(gems2)));
        System.out.println(Arrays.toString(solution(gems3)));
        System.out.println(Arrays.toString(solution(gems4)));

        System.out.println(Arrays.toString(solution(gems5)));
    }
}
