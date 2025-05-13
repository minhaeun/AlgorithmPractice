package programmers.summerWinter2019;

import java.math.BigInteger;

public class P62048_2 {
    public static long solution(int w, int h) {
        long answer = 1;
        long wl = (long)w;
        long hl = (long)h;

        answer = (wl * hl) - ((wl + hl) - gcd(wl, hl));
        return answer;
    }

    public static long gcd(long w, long h){
        if(h == 0) return w;
        return gcd(h, w%h);
    }

    public static void main(String[] args) {
        int w = 8, h = 12;

        System.out.println(solution(w, h));
    }
}
