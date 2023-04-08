package baekjoon.greedy.boj1931;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1931 {
    public static class Meeting{
        int start, end;
        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/greedy/boj1931/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> schedule = new PriorityQueue<>(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                if(o1.end == o2.end)    return o1.start - o2.start;
                else return o1.end - o2.end;
            }
        });

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            schedule.offer(new Meeting(start, end));
        }

        int count = 1;
        Meeting first = schedule.poll();
        while(!schedule.isEmpty()){
            Meeting now = schedule.poll();
            if(first.end > now.start)   continue;
            first = now;
            count++;
        }

        System.out.println(count);

    }
}
