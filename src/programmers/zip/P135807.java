package programmers.zip;

import java.util.Arrays;

public class P135807 {
    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int a = arrayA[0];
        int b = arrayB[0];

        for(int i = 1; i < arrayA.length; i++){
            a = gcd(a, arrayA[i]);
            b = gcd(b, arrayB[i]);
        }

        if(check(arrayB, a)){
            if(answer < a) answer = a;
        }
        if(check(arrayA, b)){
            if(answer < b) answer = b;
        }

        return answer;
    }
    public static boolean check(int[] arr, int n){
        for(int value : arr){
            if(value % n == 0) return false;
        }
        return true;
    }
    public static int gcd(int a, int b){
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        int[] arrayA1 = {10, 17}, arrayB1 = {5, 20};
        int[] arrayA2 = {10, 20}, arrayB2 = {5, 17};
        int[] arrayA3 = {14, 35, 119}, arrayB3 = {18, 30, 102};

        System.out.println(solution(arrayA1, arrayB1));
        System.out.println(solution(arrayA2, arrayB2));
        System.out.println(solution(arrayA3, arrayB3));
    }
}
