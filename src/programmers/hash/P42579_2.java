package programmers.hash;

import java.util.*;

public class P42579_2 {
    public static HashMap<String, Integer> genreMap;
    public static HashMap<String, HashMap<Integer, Integer>> musicMap;
    public static int[] solution(String[] genres, int[] plays) {
        genreMap = new HashMap<>();
        musicMap = new HashMap<>();
        int len = genres.length;
        for(int i = 0; i < len; i++) {
           if(!genreMap.containsKey(genres[i])){
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                musicMap.put(genres[i], map);
                genreMap.put(genres[i], plays[i]);
            }else{
                musicMap.get(genres[i]).put(i, plays[i]);
                genreMap.put(genres[i], genreMap.get(genres[i]) + plays[i]);
            }
        }
        ArrayList<String> keySet = new ArrayList<>(genreMap.keySet());
        keySet.sort((o1, o2) -> genreMap.get(o2) - genreMap.get(o1));
        ArrayList<Integer> answer = new ArrayList<>();
        for(String key : keySet){
            HashMap<Integer, Integer> map = musicMap.get(key);
            ArrayList<Integer> genreKey = new ArrayList<>(map.keySet());
            genreKey.sort((o1, o2) -> map.get(o2) - map.get(o1));
            answer.add(genreKey.get(0));
            if(genreKey.size() > 1) answer.add(genreKey.get(1));
        }
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            result[i] = answer.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        String[] genres1 = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays1 = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres1, plays1)));
    }
}
