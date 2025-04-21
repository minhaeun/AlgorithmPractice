package programmers.bruteForce;

import java.util.ArrayList;
import java.util.Collections;

public class P84512 {
    public static String[] arr = {"A", "E", "I", "O", "U"};
    public static ArrayList<String> list;
    public static int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();

        dfs(0, "");
        answer = list.indexOf(word) + 1;

        return answer;
    }
    public static void dfs(int index, String word) {
        if(index > 4) return;
        for(int i = 0 ;i < 5; i++){
            list.add(word + arr[i]);
            dfs(index + 1, word + arr[i]);
        }
    }
    public static void main(String[] args) {
        String word1 = "AAAAE";
        String word2 = "AAAE";
        String word3 = "I";
        String word4 = "EIO";

        System.out.println(solution(word1));
        System.out.println(solution(word2));
        System.out.println(solution(word3));
        System.out.println(solution(word4));
    }
}
