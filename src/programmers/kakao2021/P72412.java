package programmers.kakao2021;

import java.util.*;

public class P72412 {
    public static HashMap<String, ArrayList<Integer>> map;
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<String, ArrayList<Integer>>();

        for(int i = 0; i < info.length; i++){
            String[] p = info[i].split(" ");
            makeSentence(p, "", 0);
        }

        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }
        for(int i = 0; i < query.length; i++){
            query[i] = query[i].replaceAll(" and ", "");
            String[] q = query[i].split(" ");
            answer[i] = map.containsKey(q[0]) ? binarySearch(q[0], Integer.parseInt(q[1])) : 0;
        }
        return answer;
    }
    public static int binarySearch(String key, int score){
        ArrayList<Integer> list = map.get(key);
        int start = 0, end = list.size() - 1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(list.get(mid) < score) start = mid + 1;
            else end = mid - 1;
        }
        return list.size() - start;
    }
    public static void makeSentence(String[] p, String str, int cnt){
        if(cnt == 4){
            if(!map.containsKey(str)){
                ArrayList<Integer> list = new ArrayList<Integer>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(p[4]));
            return;
        }
        makeSentence(p, str + "-", cnt + 1);
        makeSentence(p, str + p[cnt], cnt + 1);
    }
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        System.out.println(Arrays.toString(solution(info, query)));
    }
}
