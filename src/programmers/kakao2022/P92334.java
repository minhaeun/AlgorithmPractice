package programmers.kakao2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P92334 {
    public static void main(String[] args) {
        String[] id_list1 = {"muzi", "frodo", "apeach", "neo"};
        String[] id_list2 = {"con", "ryan"};

        String[] report1 = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        String[] report2 = {"ryan con", "ryan con", "ryan con", "ryan con"};

        int k1 = 2;
        int k2 = 3;

        System.out.println(Arrays.toString(solution(id_list1, report1, k1)));
        System.out.println(Arrays.toString(solution(id_list2, report2, k2)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] count = new int[id_list.length];

        HashMap<String, HashSet<String>> hashMap1 = new HashMap<>();
        HashMap<String, HashSet<String>> hashMap2 = new HashMap<>();

        for (String str : report) {
            StringTokenizer st = new StringTokenizer(str, " ");
            String key = st.nextToken(), value = st.nextToken();

            if(hashMap1.containsKey(value)){
                hashMap1.get(value).add(key);
            }else{
                HashSet<String> tmp = new HashSet<>();
                tmp.add(key);
                hashMap1.put(value, tmp);
            }

            if(hashMap2.containsKey(key)){
                hashMap2.get(key).add(value);
            }else{
                HashSet<String> tmp2 = new HashSet<>();
                tmp2.add(value);
                hashMap2.put(key, tmp2);
            }

        }
        System.out.println();

        for(int i = 0; i < id_list.length; i++){
            String key = id_list[i];

            if(hashMap1.containsKey(key)){
                count[i] = hashMap1.get(key).size();
            }else   count[i] = 0;


        }

        for(String key : hashMap2.keySet()){
            int id = Arrays.asList(id_list).indexOf(key);
            for(String value : hashMap2.get(key)){
                int index = Arrays.asList(id_list).indexOf(value);

                if(count[index] >= k){
                    answer[id]++;
                }
            }
        }
        System.out.println();
        return answer;
    }
}
