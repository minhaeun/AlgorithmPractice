package programmers.zip;

public class P12985 {
    public int solution(int n, int a, int b){
        int low = 1, high = n;
        int mid = 0, answer = 0;

        while(low <= high){
            mid = (low + high) / 2;

            if(a <= mid && b <= mid){
                high = mid;
                n /= 2;
            }else if(a > mid && b > mid){
                low = mid + 1;
                n /= 2;
            }else{
                answer = (int) (Math.log10(n) / Math.log10(2));
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
