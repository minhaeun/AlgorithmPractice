package programmers.zip;

public class P12924 {
    public static int solution(int n) {
        int left = 1, right = 1;
        int sum = 1, count = 0;
        while(left <= right){
            if(sum <= n){
                if(sum == n) count++;
                right++;
                sum += right;
            }else{
                sum -= left;
                left++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int n1 = 15;
        System.out.println(solution(n1));
    }
}
