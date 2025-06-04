package programmers.summerWinter2018;

public class P12980 {
    public static int solution(int n) {
        int answer = 0;
        while(n >= 1){
            if(n % 2 == 0) n /= 2;
            else{
                answer++;
                n--;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 6;
        int n3 = 5000;

        System.out.println(solution(n1));
        System.out.println(solution(n2));
        System.out.println(solution(n3));
    }
}
