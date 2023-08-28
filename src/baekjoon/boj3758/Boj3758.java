package baekjoon.boj3758;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj3758 {
    public static class Team{
        int id, score, count, time;
        public Team(int id, int score, int count, int time){
            this.id = id;
            this.score = score;
            this.count = count;
            this.time = time;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj3758/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Map<Integer, Integer>[] teams;
        PriorityQueue<Team> pq;
        int[] count, time, score;


        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            count = new int[N + 1];
            time = new int[N + 1];
            score = new int[N + 1];
            teams = new Map[N + 1];
            pq = new PriorityQueue<>(new Comparator<Team>() {
                @Override
                public int compare(Team o1, Team o2) {
                    if(o1.score == o2.score){
                        if(o1.count == o2.count)    return o1.time - o2.time;
                        return o1.count - o2.count;
                    }
                    return o2.score - o1.score;
                }
            });

            for(int i = 1; i <= N; i++) teams[i] = new HashMap<>();

            int timeCheck = 0;
            for(int t = 0; t < M; t++){
                st = new StringTokenizer(br.readLine(), " ");
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                if(teams[i].containsKey(j)){
                    if(teams[i].get(j) < s) teams[i].put(j, s);
                }else teams[i].put(j, s);
                count[i]++;
                time[i] = ++timeCheck;
            }

            for(int i = 1; i <= N; i++){
                for(int value : teams[i].values()){
                    score[i] += value;
                }
            }

            for(int i = 1; i <= N; i++){
                pq.add(new Team(i, score[i], count[i], time[i]));
            }

            int ans = 1;
            while(!pq.isEmpty()){
                int id = pq.poll().id;
                if(id == T){
                    sb.append(ans).append("\n");
                    break;
                }
                ans++;
            }
        }
        System.out.println(sb);
    }
}
