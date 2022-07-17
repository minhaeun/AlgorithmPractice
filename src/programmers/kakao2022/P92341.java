package programmers.kakao2022;

import java.util.*;

public class P92341 {
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

    public static int[] solution(int[] fees, String[] records) {
        HashMap<String, Queue<Integer>> hashMap = new HashMap<>();

        for (String value : records) {
            StringTokenizer st = new StringTokenizer(value, " ");
            String time = st.nextToken();
            String carNum = st.nextToken();
            String status = st.nextToken();

            st = new StringTokenizer(time, ":");
            int h = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int minutes = h * 60 + m;

            if (hashMap.containsKey(carNum)) {
                hashMap.get(carNum).offer(minutes);
            } else {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(minutes);
                hashMap.put(carNum, queue);
            }
        }

        Map<String, Integer> sortedMap = new TreeMap<>();
        int basicTime = fees[0];
        int basicFee = fees[1];
        float unitTime = fees[2];
        int unitFee = fees[3];

        int last = 23*60+59;
        for(String key : hashMap.keySet()){
            Queue<Integer> valueQueue = hashMap.get(key);
            if(valueQueue.size()%2 != 0) valueQueue.offer(last);

            int totalTime = 0;
            int totalFee = 0;
            while(!valueQueue.isEmpty()){
                int inTime = valueQueue.poll();
                int outTime = valueQueue.poll();
                totalTime += outTime - inTime;
            }
            if(totalTime <= basicTime){
                sortedMap.put(key, basicFee);
                continue;
            }

            float remainTime = totalTime - basicTime;
            int plusFee = (int)Math.ceil(remainTime / unitTime);
            totalFee = plusFee * unitFee;
            sortedMap.put(key, basicFee + totalFee);
        }

        int[] answer = new int[sortedMap.size()];
        int count = 0;
        for(String key : sortedMap.keySet()){
            answer[count++] = sortedMap.get(key);
        }

        return answer;
    }
}
