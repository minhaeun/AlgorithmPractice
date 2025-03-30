package programmers.kakao2018;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P17678 {
    public static String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st;
        int len = timetable.length;
        for(int i = 0; i < len; i++){
            st = new StringTokenizer(timetable[i], ":");
            int hour = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());
            int time = hour * 60 + min;
            pq.offer(time);
        }

        int start = 9*60;
        int total = 0, last = 0;
        for(int i = 0; i < n; i++){
            total = 0;
            while(!pq.isEmpty()){
                int current = pq.peek();
                if(current <= start && total < m){
                    pq.poll();
                    total++;
                }else break;
                last = current - 1;
            }
            start += t;
        }
        if(total < m) last = start - t;

        StringBuilder sb = new StringBuilder();
        int hour = last / 60;
        int min = last % 60;
        if(hour < 10) sb.append(0);
        sb.append(hour).append(":");
        if(min < 10) sb.append(0);
        sb.append(min);

        return sb.toString();
    }
    public static void main(String[] args) {
        int n1 = 1, t1 = 1, m1 = 5;
        String[] timetable1 = {"08:00", "08:01", "08:02", "08:03"};
        int n2 = 2, t2 = 10, m2 = 2;
        String[] timetable2 = {"09:10", "09:09", "08:00"};
        int n3 = 2, t3 = 1, m3 = 2;
        String[] timetable3 = {"09:00", "09:00", "09:00", "09:00"};
        int n4 = 1, t4 = 1, m4 = 5;
        String[] timetable4 = {"00:01", "00:01", "00:01", "00:01", "00:01"};
        int n5 = 1, t5 = 1, m5 = 1;
        String[] timetable5 = {"23:59"};
        int n6 = 10, t6 = 60, m6 = 45;
        String[] timetable6 = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};

        System.out.println(solution(n1, t1, m1, timetable1));
        System.out.println(solution(n2, t2, m2, timetable2));
        System.out.println(solution(n3, t3, m3, timetable3));
        System.out.println(solution(n4, t4, m4, timetable4));
        System.out.println(solution(n5, t5, m5, timetable5));
        System.out.println(solution(n6, t6, m6, timetable6));


    }
}
