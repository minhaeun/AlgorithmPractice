package programmers.kakao2019;

public class P64062 {
    public static int solution(int[] stones, int k) {
        int answer = 0;

        int left = 0, right = 200000000;
        while(left <= right){
            int mid = (left + right) / 2;
            if(check(mid, stones, k)){
                left = mid + 1;
                answer = Math.max(answer, mid);
            }else right = mid - 1;
        }
        return answer;
    }
    public static boolean check(int n, int[] stones, int k) {
        int count = 0;
        int len = stones.length;
        for(int i = 0; i < len; i++){
            if(stones[i] < n) count++;
            else count = 0;
            if(count >= k) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int sontes1[] = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, k1 = 3;

        System.out.println(solution(sontes1, k1));
    }
}
