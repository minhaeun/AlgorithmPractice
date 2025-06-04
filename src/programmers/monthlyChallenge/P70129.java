package programmers.monthlyChallenge;

import java.util.Arrays;

public class P70129 {
    public static int[] solution(String s) {
        int count0 = 0, cycle = 0;
        while(!s.equals("1")){
            int len = s.length();
            int count1 = 0;
            for(char ch : s.toCharArray()){
                if(ch == '1') count1++;
            }
            count0 += len - count1;
            s = Integer.toBinaryString(count1);
            cycle++;
        }
        return new int[]{cycle, count0};
    }
    public static void main(String[] args) {
        String s1 = "110010101001";
        String s2 = "01110";
        String s3 = "1111111";

        System.out.println(Arrays.toString(solution(s1)));
        System.out.println(Arrays.toString(solution(s2)));
        System.out.println(Arrays.toString(solution(s3)));
    }
}
