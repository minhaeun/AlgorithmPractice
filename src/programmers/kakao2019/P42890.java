package programmers.kakao2019;

import java.util.ArrayList;
import java.util.HashMap;

public class P42890 {
    public static ArrayList<String> answer = new ArrayList<>();
    public static int solution(String[][] relation) {

        int len = relation[0].length;
        for(int i = 0; i < len; i++){
            boolean[] visited = new boolean[len];
            dfs(visited, 0, 0, i + 1, relation);
        }

        return answer.size();
    }
    public static void dfs(boolean[] visited, int start, int depth, int end, String[][] relation) {
        if(depth == end){
            ArrayList<Integer> list = new ArrayList<>();
            int len = visited.length;
            String key = "";
            for(int i = 0; i < len; i++){
                if(visited[i]){
                    key += String.valueOf(i);
                    list.add(i);
                }
            }
            HashMap<String, Integer> map = new HashMap<>();
            len = relation.length;
            for(int i = 0; i < len; i++){
                String str = "";
                for(int j : list){
                    str += relation[i][j];
                }
                if(map.containsKey(str)) return;
                else map.put(str, 0);
            }
            for(String s : answer){
                int count = 0;
                for(int i = 0; i < key.length(); i++){
                    String sub = String.valueOf(key.charAt(i));
                    if(s.contains(sub)) count++;
                }
                if(count == s.length()) return;
            }
            answer.add(key);
            return;
        }
        for(int i = start; i < visited.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(visited, i, depth + 1, end, relation);
            visited[i] = false;
        }
    }


    public static void main(String[] args) {
        String[][] relation1 = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        System.out.println(solution(relation1));
    }
}
