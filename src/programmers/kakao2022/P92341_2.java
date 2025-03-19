package programmers.kakao2022;

import java.util.*;

public class P92341_2 {
    public static int[] solution(int[] fees, String[] records) {
        int[] answer;
        StringTokenizer st1, st2;
        HashMap<String, Queue<Integer>> map = new HashMap<>();
        for (String record : records) {
            st1 = new StringTokenizer(record, " ");
            String str = st1.nextToken();
            st2 = new StringTokenizer(str, ":");
            int hour = Integer.parseInt(st2.nextToken());
            int minute = Integer.parseInt(st2.nextToken());
            int time = hour * 60 + minute;
            String num = st1.nextToken();

            if(map.containsKey(num)) {
                map.get(num).offer(time);
            }else{
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(time);
                map.put(num, queue);
            }
        }

        int size = map.size();
        answer = new int[size];
        TreeMap<String, Integer> sortedMap = new TreeMap<>();
        for(String key : map.keySet()) {
            Queue<Integer> queue = map.get(key);
            int queueSize = queue.size();
            if(queueSize % 2 != 0) queue.offer(23*60 + 59);
            int time = 0, total = fees[1];
            while(!queue.isEmpty()){
                int in = queue.poll();
                int out = queue.poll();

                time += out - in;
            }
            if(time > fees[0]){
                time -= fees[0];
                total += (int)Math.ceil((double)time / fees[2]) * fees[3];
            }
            sortedMap.put(key, total);
        }
        int i = 0;
        for(String key : sortedMap.keySet()) {
            answer[i++] = sortedMap.get(key);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] fees1 = {180, 5000, 10, 600};
        int[] fees2 = {120, 0, 60, 591};
        int[] fees3 = {1, 461, 1, 10};

        String[] records1 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        String[] records2 = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
        String[] records3 = {"00:00 1234 IN"};

        System.out.println(Arrays.toString(solution(fees1, records1)));
        System.out.println(Arrays.toString(solution(fees2, records2)));
        System.out.println(Arrays.toString(solution(fees3, records3)));

    }
}
