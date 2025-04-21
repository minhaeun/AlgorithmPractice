package programmers.kakao2022;

import java.util.StringTokenizer;

public class P92335 {
    public static int solution(int n, int k) {
        int answer = 0;

        String str = Long.toString(n, k);
        StringTokenizer st = new StringTokenizer(str, "0");
        while (st.hasMoreTokens()) {
            long num = Long.parseLong(st.nextToken(), 10);
            if(isPrime(num)) answer++;
        }
        return answer;
    }
    public static boolean isPrime(long num) {
        if(num < 2) return false;
        if(num == 2) return true;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int n1 = 437674, k1 = 3;
        int n2 = 110011, k2 = 10;

        System.out.println(solution(n1, k1));
        System.out.println(solution(n2, k2));
    }
}
