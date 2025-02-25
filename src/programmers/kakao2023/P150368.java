package programmers.kakao2023;

import java.util.Arrays;

public class P150368 {
    public static int[] percents = {10, 20, 30, 40};
    public static int maxCount, maxCost;
    public static int[] solution(int[][] users, int[] emoticons) {
        find(0, new int[emoticons.length], users, emoticons);
        return new int[]{maxCount, maxCost};
    }

    public static void find(int index, int[] discount, int[][] users, int[] emoticons){
        if(index == emoticons.length){
            int count = 0, cost = 0;

            for(int[] user : users){
                int userPer = user[0];
                int userCost = user[1];
                int sum = 0;
                for(int i = 0; i < emoticons.length; i++){
                    if(discount[i] >= userPer) sum += emoticons[i] * (100 - discount[i]) / 100;
                }
                if(sum >= userCost) count++;
                else cost += sum;
            }
            if(count > maxCount){
                maxCount = count;
                maxCost = cost;
            }else if(count == maxCount){
                maxCost = Math.max(maxCost, cost);
            }
            return;
        }
        for(int i = 0; i < 4; i++){
            discount[index] = percents[i];
            find(index + 1, discount, users, emoticons);
        }
    }

    public static void main(String[] args) {
        int users1[][] = {{40, 10000}, {25, 10000}}, emoticons1[] = {7000, 9000};
        int users2[][] = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}}, emoticons2[] = {1300, 1500, 1600, 4900};

        System.out.println(Arrays.toString(solution(users1, emoticons1)));
        System.out.println(Arrays.toString(solution(users2, emoticons2)));

    }




}
