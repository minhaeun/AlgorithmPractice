package programmers.kakao2023;

public class P150369 {
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int d = 0, p = 0;

        for(int i = n - 1; i >= 0; i--){
            d -= deliveries[i];
            p -= pickups[i];

            while(d < 0 || p < 0){
                d += cap;
                p += cap;
                answer += (i + 1) * 2;
            }
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
