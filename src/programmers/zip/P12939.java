package programmers.zip;

import java.util.Arrays;
import java.util.StringTokenizer;

public class P12939 {
    public static String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        StringBuilder sb = new StringBuilder();
        int size = st.countTokens();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        sb.append(arr[0]).append(" ").append(arr[size - 1]);

        return sb.toString();
    }
    public static void main(String[] args) {
        String s1 = "1 2 3 4";
        String s2 = "-1 -2 -3 -4";
        String s3 = "-1 -1";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
    }
}
