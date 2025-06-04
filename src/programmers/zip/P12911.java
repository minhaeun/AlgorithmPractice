package programmers.zip;

public class P12911 {
    public static int solution(int n) {
        int answer = 0;

        int countN = Integer.bitCount(n);

        while(true){
            n++;
            if(countN == Integer.bitCount(n)){
                answer = n;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {

        int n1 = 78;
        int n2 = 15;

        System.out.println(solution(n1));
        System.out.println(solution(n2));
    }
}
