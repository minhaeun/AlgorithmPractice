package programmers.zip;

public class P12904 {
    public static int solution(String s){
        int answer = 1;

        int len = s.length();
        int count1 = 1;
        if(s.isEmpty()) return 0;
        if(s.length() == 1) return 1;
        // 홀수
        for(int i = 1; i < len - 1; i++){
            for(int j = 1; j < len; j++){
                int left = i - j;
                int right = i + j;
                if(left < 0 || right > len - 1) break;
                if(s.charAt(left) == s.charAt(right)) count1++;
                else break;
            }
            answer = Math.max(answer, count1);
            count1 = 1;
        }
        answer = (answer - 1) * 2 + 1;
        // 짝수
        int count2 = 0, max = 0;
        for(int i = 0; i < len - 1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                count2 += 2;
                for(int j = 1; j < len; j++){
                    int left = i - j;
                    int right = (i + 1) + j;
                    if(left < 0 || right > len - 1) break;
                    if(s.charAt(left) == s.charAt(right)) count2+= 2;
                    else break;
                }
                max = Math.max(max, count2);
                count2 = 0;
            }
        }
        answer = Math.max(answer, max);
        return answer;
    }
    public static void main(String[] args) {
        String s1 = "abcdcba";
        String s2 = "abacde";
        String s3 = "abba";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
    }
}
