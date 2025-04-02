package programmers.kakao2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class P72411 {
    public static ArrayList<String> list;
    public static HashMap<String, Integer> map;
    public static boolean[] visited;
    public static String[] solution(String[] orders, int[] course) {
        list = new ArrayList<>();
        map = new HashMap<>();

        for(String order : orders) {
            for(int i = 0; i < course.length; i++) {
                visited = new boolean[order.length()];
                char[] chars = order.toCharArray();
                Arrays.sort(chars);
                String s = String.valueOf(chars);
                comb("", 0, 0, s, course[i]);
            }
        }

        for (int num : course) {
            int max = 0;
            ArrayList<String> tmp = new ArrayList<>();
            for (String key : map.keySet()) {
                int value = map.get(key);
                if (key.length() != num || value < 2) continue;
                if (max < value) {
                    max = value;
                    tmp = new ArrayList<>();
                    tmp.add(key);
                } else if (max == value) {
                    tmp.add(key);
                }
            }
            list.addAll(tmp);
        }

        Collections.sort(list);
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static void comb(String str, int count, int now, String order, int course) {
        if(count == course) {
            //System.out.println(str);
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }

        for(int i = now; i < order.length(); i++){
            if(visited[i]) continue;
            visited[i] = true;
            String tmp = str + order.charAt(i);
            comb(tmp, count + 1, i + 1, order, course);
            visited[i] = false;
        }
    }


    public static void main(String[] args) {
        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = {2,3,4};
        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2,3,5};
        String[] orders3 = {"XYZ", "XWY", "WXA"};
        int[] course3 = {2,3,4};
        String[] orders4 = {"ABCD", "ABCD", "ABCD"};
        int[] course4 = {2,3,4};

        System.out.println(Arrays.toString(solution(orders1, course1)));
        System.out.println(Arrays.toString(solution(orders2, course2)));
        System.out.println(Arrays.toString(solution(orders3, course3)));
        System.out.println(Arrays.toString(solution(orders4, course4)));
    }
}
