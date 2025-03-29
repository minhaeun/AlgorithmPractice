package programmers.zip;

public class P148653 {
    public static int solution(int storey) {
        int answer = 0;
        while(storey > 0) {
            int value = storey % 10;
            storey /= 10;
            if(value == 5){
                if(storey % 10 >= 5){
                    answer += 10 - value;
                    storey++;
                }else{
                    answer += value;
                }
            }else if(value > 5){
                answer += 10 - value;
                storey++;
            }else{
                answer += value;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int storey1 = 16;
        int storey2 = 2554;

        System.out.println(solution(storey1));
        System.out.println(solution(storey2));
    }
}
