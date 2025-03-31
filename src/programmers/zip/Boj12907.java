package programmers.zip;

import java.util.Arrays;

public class Boj12907 {
    public static int solution(int n, int[] money) {
        int[] arr = new int[100001];

        Arrays.sort(money);
        arr[0] = 1;
        int len = money.length;
        for(int i = 0; i < len; i++){
            for(int j = money[i]; j <= n; j++){
                arr[j] += arr[j - money[i]] % 1000000007;
            }
        }
        return arr[n];
    }
    public static void main(String[] args) {
        int n = 5, money[] = {1, 2, 5};

        System.out.println(solution(n, money));
    }
}
