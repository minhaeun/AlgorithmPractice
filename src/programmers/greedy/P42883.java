package programmers.greedy;

public class P42883 {
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int len = number.length();
        for(int i = 0; i < len - k; i++){
            char max = 0;
            for(int j = idx; j <= i + k; j++){
                if(max < number.charAt(j)){
                    max = number.charAt(j);
                    idx = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String number1 = "1924"; int k1 = 2;
        String number2 = "1231234"; int k2 = 3;
        String number3 = "4177252841"; int k3 = 4;

        System.out.println(solution(number1, k1));
        System.out.println(solution(number2, k2));
        System.out.println(solution(number3, k3));

    }
}
