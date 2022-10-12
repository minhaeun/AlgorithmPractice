package baekjoon.boj2109;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2109 {
    static int n, d, p;
    public static class Lecture implements Comparable<Lecture>{
        int day, pay;
        Lecture(int day, int pay){
            this.day = day;
            this.pay = pay;
        }

        @Override
        public int compareTo(Lecture o) {
            if(this.pay != o.pay)    return o.pay - this.pay;
            else return this.day - o.day;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2109/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Lecture> pq = new PriorityQueue<>();

        n = Integer.parseInt(br.readLine());
        int max = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            max = Math.max(max, d);
            pq.add(new Lecture(d, p));
        }

        int[] payArr = new int[max+1];
        while(!pq.isEmpty()){
            Lecture lecture = pq.poll();
            for(int i = lecture.day; i > 0; i--){
                if(payArr[i] < lecture.pay){
                    payArr[i] = lecture.pay;
                    break;
                }
            }
        }
        int total = 0;
        for(int i = 0; i < payArr.length; i++){
            total += payArr[i];
        }
        System.out.println(total);
    }
}
