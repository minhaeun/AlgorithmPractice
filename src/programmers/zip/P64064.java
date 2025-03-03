package programmers.zip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class P64064 {
    public static HashSet<String> set;
    public static int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<>();

        choose(0, new String[banned_id.length], new boolean[user_id.length], user_id, banned_id);
        int answer = set.size();

        return answer;
    }

    public static void choose(int count, String[] arr, boolean[] visited, String[] user_id, String[] banned_id){
        if(count == banned_id.length){
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < arr.length; i++){
                list.add(arr[i]);
            }
            Collections.sort(list);
            String str = "";
            for(int i = 0; i < arr.length; i++){
                str += list.get(i);
            }
            set.add(str);
            return;
        }

        for(int i = 0; i < user_id.length; i++){
            if(visited[i] || !check(user_id[i], banned_id[count])) continue;
            visited[i] = true;
            arr[count] = user_id[i];
            choose(count + 1, arr, visited, user_id, banned_id);
            visited[i] = false;
        }
    }

    public static boolean check(String user_id, String banned_id){
        if(user_id.length() != banned_id.length()) return false;
        for(int i = 0; i < user_id.length(); i++){
            if(banned_id.charAt(i) == '*') continue;
            if(user_id.charAt(i) != banned_id.charAt(i)) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String[] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"}, banned_id1 = {"fr*d*", "abc1**"};
        String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"}, banned_id2 = {"*rodo", "*rodo", "******"};
        String[] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"}, banned_id3 = {"fr*d*", "*rodo", "******", "******"};

        System.out.println(solution(user_id1, banned_id1));
        System.out.println(solution(user_id2, banned_id2));
        System.out.println(solution(user_id3, banned_id3));

    }
}
