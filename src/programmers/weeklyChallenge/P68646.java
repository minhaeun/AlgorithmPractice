package programmers.weeklyChallenge;

public class P68646 {
    public static int solution(int[] a) {
        int answer = 2;
        int len = a.length;
        int[] leftMin = new int[len];
        int[] rightMin = new int[len];
        int left = a[0];
        int right = a[len - 1];

        if(len == 1) return 1;

        for(int i = 1; i < len - 1; i++){
            if(left > a[i]) left = a[i];
            leftMin[i] = left;
        }

        for(int i = len - 2; i > 0; i--){
            if(right > a[i]) right = a[i];
            rightMin[i] = right;
        }
        for(int i = 1; i < len - 1; i++){
            if(leftMin[i] < a[i] && rightMin[i] < a[i]) continue;
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] a1 = {9,-1,-5};
        int[] a2 = {-16,27,65,-2,58,-92,-71,-68,-61,-33};

        System.out.println(solution(a1));
        System.out.println(solution(a2));
    }
}
