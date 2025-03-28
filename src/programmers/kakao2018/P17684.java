package programmers.kakao2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class P17684 {
    public static ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        int idx = 1;
        for(char ch = 'A'; ch <= 'Z'; ch++){
            map.put(String.valueOf(ch), idx++);
        }

        int len = msg.length();
        for(int i = 0; i < len; i++){
            String word = "";
            while(i < len && map.containsKey(word + msg.charAt(i))){
                word += msg.charAt(i++);
            }
            answer.add(map.get(word));

            if(i < len){
                map.put(word + msg.charAt(i--), idx++);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        String msg1 = "KAKAO";
        String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
        String msg3 = "ABABABABABABABAB";

        System.out.println(solution(msg1));
        System.out.println(solution(msg2));
        System.out.println(solution(msg3));
    }
}
