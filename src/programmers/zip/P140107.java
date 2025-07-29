package programmers.zip;

public class P140107 {
    public long solution(int k, int d) {
        long answer = 0;

        for(int i = 0; i < d + 1; i+=k){
            long b = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2));
            answer += (long) b/k + 1;
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
