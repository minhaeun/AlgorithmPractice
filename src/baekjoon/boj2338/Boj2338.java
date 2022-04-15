package baekjoon.boj2338;

import java.math.BigInteger;
import java.util.Scanner;

public class Boj2338 {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        BigInteger A = scan.nextBigInteger();
        BigInteger B = scan.nextBigInteger();

        sb.append(A.add(B)).append("\n").append(A.subtract(B)).append("\n").append(A.multiply(B));
        System.out.println(sb.toString());


    }

}
