package baekjoon.boj13904;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj13904 {
    public static class Work{
        int day, score;
        Work(int day, int score){
            this.day = day;
            this.score = score;
        }

    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj13904/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        List<Work> list = new ArrayList<>();
        int maxDay = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            list.add(new Work(day, score));
            maxDay = Math.max(day, maxDay);

        }

        int totalScore = 0;
        for(int m = maxDay; m >= 1; m--){
            int maxScore = 0, maxIndex = 0, len = list.size();
            for(int i = 0; i < len; i++) {
                if (list.get(i).day >= m) {
                    if (maxScore < list.get(i).score) {
                        maxScore = list.get(i).score;
                        maxIndex = i;
                    }
                }

            }

            if(maxScore == 0)   continue;
            totalScore += maxScore;
            list.remove(list.get(maxIndex));
        }
        System.out.println(totalScore);

    }
}
