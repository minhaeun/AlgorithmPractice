package programmers.kakao2021;

import java.util.*;

public class P2 {
    static HashMap<String, Integer> hashMap;
    static List<String> answerList;


    public static String[] solution(String[] orders, int[] course){
        hashMap = new HashMap<>();
        answerList = new ArrayList<>();

        // 각 order 정렬
        for(int i = 0; i < orders.length; i++){
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        // 조합 만들기
        for(int count : course){
            for(String str : orders){
                comb("", str, count);
            }

            // map value값 list에 저장 후 최대값 찾기
            if(!hashMap.isEmpty()){
                List<Integer> list = new ArrayList<>(hashMap.values());
                int max = Collections.max(list);

                if(max > 1){
                    for(String key : hashMap.keySet()){
                        if(hashMap.get(key) == max) answerList.add(key);
                    }
                }
                hashMap.clear();
            }

        }

        Set<String> keySet = hashMap.keySet();
        for(String key : keySet){
            System.out.println(key + " : " + hashMap.get(key));
        }

        Collections.sort(answerList);
        String[] answers = new String[answerList.size()];
        for(int i = 0; i < answers.length; i++){
            answers[i] = answerList.get(i);
        }
        return answers;
    }

    public static void comb(String order, String str, int count){
        if(count == 0){
            hashMap.put(order, hashMap.getOrDefault(order, 0) + 1);
            return;
        }

        for(int i = 0; i < str.length(); i++){
            comb(order + str.charAt(i), str.substring(i + 1), count - 1);
        }
    }

    public static void main(String[] args) {
        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        String[] orders3 = {"XYZ", "XWY", "WXA"};

        int[] course1 = {2, 3, 4};
        int[] course2 = {2, 3, 5};
        int[] course3 = {2, 3, 4};

        System.out.println(Arrays.toString(solution(orders1, course1)));
        System.out.println(Arrays.toString(solution(orders2, course2)));
        System.out.println(Arrays.toString(solution(orders3, course3)));
    }
}
