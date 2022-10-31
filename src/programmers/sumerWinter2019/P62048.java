package programmers.sumerWinter2019;

import java.math.BigInteger;

public class P62048 {
    public static void main(String[] args) {
        int w = 8, h = 12;
        System.out.println(solution(w, h));
    }

    public static long solution(int w, int h) {
        long result = (long)w * (long)h;
       //return result - (w + h - gcb(w,h)) ;
        BigInteger w1 = BigInteger.valueOf(w);
        BigInteger h1 = BigInteger.valueOf(h);
        BigInteger gcd = w1.gcd(h1);

        return result - (w + h - gcd.intValue());
    }


    public static int gcb(int a, int b){
        int tmp;
        while( b != 0 ){
            tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}
