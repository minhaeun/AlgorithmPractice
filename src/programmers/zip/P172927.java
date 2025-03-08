package programmers.zip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class P172927 {
    public static int[][] board;
    public static ArrayList<Mineral> list;
    public static class Mineral{
        int diamond, iron, stone;
        public Mineral(int diamond, int iron, int stone){
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }
    }
    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        board = new int[][] {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        list = new ArrayList<>();

        int total = Arrays.stream(picks).sum();
        for(int i = 0; i < minerals.length; i+= 5){
            if(total == 0) break;
            int diamond = 0, iron = 0, stone = 0;
            for(int j = i; j < i + 5; j++){
                if(j == minerals.length) break;
                String mineral = minerals[j];
                int value = mineral.equals("iron") ? 1 :
                        mineral.equals("stone") ? 2 : 0;
                diamond += board[0][value];
                iron += board[1][value];
                stone += board[2][value];
            }
            list.add(new Mineral(diamond, iron, stone));
            total--;
        }

        Collections.sort(list, new Comparator<Mineral>() {
            @Override
            public int compare(Mineral o1, Mineral o2) {
                return o2.stone - o1.stone;
            }
        });

        for(Mineral m : list){
            int diamond = m.diamond;
            int iron = m.iron;
            int stone = m.stone;

            if(picks[0] > 0){
                answer += diamond;
                picks[0]--;
                continue;
            }
            if(picks[1] > 0){
                answer += iron;
                picks[1]--;
                continue;
            }
            if(picks[2] > 0){
                answer += stone;
                picks[2]--;
                continue;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] picks1 = {1, 3, 2}; String[] minerals1 = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        int[] picks2 = {0, 1, 1}; String[] minerals2 = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

        System.out.println(solution(picks1, minerals1));
        System.out.println(solution(picks2, minerals2));

    }
}
