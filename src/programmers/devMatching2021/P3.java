package programmers.devMatching2021;

import java.util.Arrays;
import java.util.HashMap;

public class P3 {
    static class Person {
        String name;
        Person parent;
        int profit;

        public Person(String name, Person parent, int profit) {
            this.name = name;
            this.parent = parent;
            this.profit = profit;
        }

        public void CalcProfit(int profit) {
            int profitToParent = profit / 10;
            this.profit += profit - profitToParent;
            if (this.parent != null && profitToParent >= 1) {
                this.parent.CalcProfit(profitToParent);
            }
        }
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, Person> personMap = new HashMap<>();
        for (String name : enroll) {
            personMap.put(name, new Person(name, null, 0));
        }

        for (int i = 0; i < enroll.length; i++) {
            if (referral[i].equals("-")) {
                continue;
            }
            personMap.get(enroll[i]).parent = personMap.get(referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            personMap.get(seller[i]).CalcProfit(amount[i] * 100);
        }

        int[] result = new int[enroll.length];

        for (int i = 0; i < result.length; i++) {
            result[i] = personMap.get(enroll[i]).profit;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
    }


}
