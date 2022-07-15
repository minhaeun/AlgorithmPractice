package programmers.kakao2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class P42889 {
    public static void main(String[] args) {
        int N1 = 5, N2 = 4;
        int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] stages2 = {4, 4, 4, 4, 4};

        System.out.println(Arrays.toString(solution(N1, stages1)));
        System.out.println(Arrays.toString(solution(N2, stages2)));
    }

    public static class Stage {
        int number;
        double rate;

        public Stage(int number, double rate) {
            this.number = number;
            this.rate = rate;
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int[] users = new int[N + 2];
        int[] total = new int[N + 1];

        for (int i = 0; i < stages.length; i++) {
            users[stages[i]]++;
        }

        total[N] = users[N] + users[N + 1];
        for (int i = N - 1; i >= 1; i--) {
            total[i] = users[i] + total[i + 1];
        }

        // System.out.println(Arrays.toString(total));

        ArrayList<Stage> arrayList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (total[i] == 0) {
                arrayList.add(new Stage(i, 0));
                continue;
            }

            double rate = (double) users[i] / total[i];
            arrayList.add(new Stage(i, rate));
        }

        Collections.sort(arrayList, (o1, o2) -> Double.compare(o2.rate, o1.rate));

        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i).number;
        }
        return answer;


    }
}
