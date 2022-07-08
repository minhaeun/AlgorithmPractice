package programmers.kakao2022;

import java.util.*;

public class P17678 {
    public static void main(String[] args) {
        int n1 = 1, n2 = 2, n3 = 2, n4 = 1, n5 = 1, n6 = 10;
        int t1 = 1, t2 = 10, t3 = 1, t4 = 1, t5 = 1, t6 = 60;
        int m1 = 5, m2 = 2, m3 = 2, m4 = 5, m5 = 1, m6 = 45;
        String[] timetable1 = {"08:00", "08:01", "08:02", "08:03"};
        String[] timetable2 = {"09:10", "09:09", "08:00"};
        String[] timetable3 = {"09:00", "09:00", "09:00", "09:00"};
        String[] timetable4 = {"00:01", "00:01", "00:01", "00:01", "00:01"};
        String[] timetable5 = {"23:59"};
        String[] timetable6 = {"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};

        System.out.println(solution(n1, t1, m1, timetable1));
        System.out.println(solution(n2, t2, m2, timetable2));
        System.out.println(solution(n3, t3, m3, timetable3));
        System.out.println(solution(n4, t4, m4, timetable4));
        System.out.println(solution(n5, t5, m5, timetable5));
        System.out.println(solution(n6, t6, m6, timetable6));

    }

    public static int changeMinutes(String time){
        StringTokenizer st = new StringTokenizer(time, ":");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        return h * 60 + m;
    }

    public static String changeTime(int minutes){
        StringBuilder sb = new StringBuilder();
        int h = minutes / 60;
        int m = minutes % 60;
        if(h < 10)  sb.append(0);
        sb.append(h).append(":");
        if(m < 10)  sb.append(0);
        sb.append(m);
        return sb.toString();
    }


    public static String solution(int n, int t, int m, String[] timetable) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String time : timetable){
            pq.offer(changeMinutes(time));
        }

        int start = 9*60;
        int total = 0, last = 0;
        for(int i = 0; i < n; i++){
            total = 0;
            while(!pq.isEmpty()){
                int current= pq.peek();
                if(current <= start && total < m){
                    pq.poll();
                    total++;
                }else   break;
                last = current - 1;
            }
            start += t;
        }
        if(total < m)   last = start - t;

        return changeTime(last);
    }
}
