package programmers.zip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P64064_2 {
    public static int solution(String[] user_id, String[] banned_id) {

        Set<Set<String>> set = new HashSet<>();
        Set<String> answer = new HashSet<>();

        dfs(user_id, banned_id, set, answer, 0);

        return set.size();
    }

    public static void dfs(String[] user_id, String[] banned_id, Set<Set<String>> set, Set<String> answer, int depth){
        if(depth == banned_id.length){
            set.add(new HashSet<>(answer));
            return;
        }

        for(int i = 0; i < user_id.length; i++){
            if(user_id[i].matches(banned_id[depth].replace("*", ".")) && !answer.contains(user_id[i])){
                answer.add(user_id[i]);
                dfs(user_id, banned_id, set, answer, depth + 1);
                answer.remove(user_id[i]);
            }
        }
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
