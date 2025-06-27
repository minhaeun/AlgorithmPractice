package programmers.zip;

public class P12953 {
    public int gcd(int a, int b){
        int r = a % b;
        if(r == 0) return b;
        else return gcd(b, r);
    }
    public int solution(int[] arr) {
        int answer = 0;
        int len = arr.length;
        if(len == 1) return arr[0];

        int g = gcd(arr[0], arr[1]);
        answer = (arr[0] * arr[1]) / g;

        if(len > 2){
            for(int i = 2; i < len; i++){
                g = gcd(answer, arr[i]);
                answer = (answer * arr[i]) / g;
            }
        }
        return answer;
    }
    public static void main(String[] args) {

    }
}
