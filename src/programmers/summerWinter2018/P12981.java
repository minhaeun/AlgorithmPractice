package programmers.summerWinter2018;

import java.util.HashSet;

public class P12981 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>();

        int len = words.length;
        int index = 0;
        String before = words[0];
        set.add(before);
        for(int i = 1; i < len; i++){
            String now = words[i];
            if(set.contains(now)){
                index = i;
                break;
            }
            int bLen = before.length();
            if(before.charAt(bLen - 1) != now.charAt(0)){
                index = i;
                break;
            }
            set.add(now);
            before = now;
        }
        if(index != 0){
            answer[0] = index % n + 1;
            answer[1] = index / n + 1;
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
