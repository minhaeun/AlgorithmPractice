package programmers.weeklyChallenge;

public class P2 {
    public static long solution(int price, int money, int count) {
        long answer = -1;
        long totalMoney = 0;
        while(count-- > 0)  totalMoney += (count+1)*price;

        answer = totalMoney - money;
        if(answer > 0)  return answer;
        else    return 0;


    }

    public static void main(String[] args) {
        int price = 3, money = 20, count = 4;
        System.out.println(solution(price, money, count));
    }
}
