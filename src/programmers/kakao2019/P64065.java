package programmers.kakao2019;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P64065 {
    public static class Num{
        int key, count;
        public Num(int key, int count) {
            this.key = key;
            this.count = count;
        }
    }
    public static int[] solution(String s) {
        StringTokenizer st = new StringTokenizer(s, "{|}|,");

        HashMap<Integer, Integer> map = new HashMap<>();

        while(st.hasMoreTokens()){
            int a = Integer.parseInt(st.nextToken());
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        int size = map.size();
        Num[] arr = new Num[size];
        int index = 0;
        for(int key : map.keySet()){
            int count = map.get(key);
            arr[index++] = new Num(key, count);
        }
        Arrays.sort(arr, ((o1, o2) -> o2.count - o1.count));
        int[] answer = new int[size];
        for(int i = 0; i < size; i++){
            answer[i] = arr[i].key;
        }
        return answer;
    }
    public static void main(String[] args) {
        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s3 = "{{20,111},{111}}";
        String s4 = "{{123}}";
        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}"	;

        System.out.println(Arrays.toString(solution(s1)));
        System.out.println(Arrays.toString(solution(s2)));
        System.out.println(Arrays.toString(solution(s3)));
        System.out.println(Arrays.toString(solution(s4)));
        System.out.println(Arrays.toString(solution(s5)));
    }
}
