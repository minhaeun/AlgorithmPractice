package programmers.zip;

public class P12899 {
    public static String solution(int n) {
        String answer = "";
        String[] numbers = {"4", "1", "2"};

        while(n > 0){
            int remainder = n % 3;
            n /= 3;
            if(remainder == 0) n--;
            answer = numbers[remainder] + answer;
        }
        return answer;
    }
    public static void main(String[] args) {
        int n1 = 1;
        int n2 = 2;
        int n3 = 3;
        int n4 = 4;

        System.out.println(solution(n1));
        System.out.println(solution(n2));
        System.out.println(solution(n3));
        System.out.println(solution(n4));

    }
}
