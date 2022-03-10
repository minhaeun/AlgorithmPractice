package baekjoon.boj14469;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj14469 {
    static int N;
    public static class Cow implements Comparable<Cow>{
        int arrive_time, check;
        public Cow(int arrive_time, int check){
            this.arrive_time = arrive_time;
            this.check = check;
        }

        @Override
        public int compareTo(Cow o) {
            return this.arrive_time - o.arrive_time;
        }
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj14469/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Cow[] cows = new Cow[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");

            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(cows);

        int time = cows[0].arrive_time;
        for(int i = 0; i < N; i++){
            if(time < cows[i].arrive_time) time = cows[i].arrive_time;
            time += cows[i].check;
        }
        System.out.println(time);


    }
}
