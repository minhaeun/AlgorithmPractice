package programmers.zip;

import java.util.Arrays;
import java.util.Comparator;

public class P42884 {
    public static int solution(int[][] routes) {
        int answer = 1;

        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int before = routes[0][1];
        for(int i = 1; i < routes.length; i++){
            int a = routes[i][0];
            int b = routes[i][1];
            if(a <= before && b >= before) continue;
            answer++;
            before = routes[i][1];
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] routes1 = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};

        System.out.println(solution(routes1));
    }
}
