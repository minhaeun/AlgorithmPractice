package programmers.hash;

import java.util.*;

public class P42579 {
    static HashMap<String, Integer> genresMap;
    static HashMap<String, HashMap<Integer, Integer>> musicMap;
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }
    public static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        genresMap = new HashMap<>();
        musicMap = new HashMap<>();


        for(int i = 0; i < genres.length; i++){
            if(!genresMap.containsKey(genres[i])){
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                musicMap.put(genres[i], map);
                genresMap.put(genres[i], plays[i]);
            }else{
                musicMap.get(genres[i]).put(i, plays[i]);
                genresMap.put(genres[i], genresMap.get(genres[i]) + plays[i]);
            }

        }


        ArrayList<String>  keySet = new ArrayList<>(genresMap.keySet());
        Collections.sort(keySet, ((o1, o2) -> genresMap.get(o2) - genresMap.get(o1)));

        for(String key : keySet){
            HashMap<Integer, Integer> map = musicMap.get(key);
            ArrayList<Integer> genreKey = new ArrayList<>(map.keySet());

            Collections.sort(genreKey, ((o1, o2) -> map.get(o2) - map.get(o1)));

            answer.add(genreKey.get(0));
            if(genreKey.size() > 1) answer.add(genreKey.get(1));

        }
        int[] tmp = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++){
            tmp[i] = answer.get(i);
        }

        return tmp;
    }
}
