package programmers.kakao2020;

public class P60057 {
    public static int solution(String s) {
        int count = 1;
        int len = s.length();
        int answer = len;
        for(int i = 1; i < len / 2 + 1; i++){
            StringBuilder sb = new StringBuilder();
            String str = s.substring(0, i);
            for(int j = i; j < len + 1; j += i){
                int end = Math.min(j + i, len);
                String compare = s.substring(j, end);
                if(str.equals(compare)) count++;
                else{
                    if(count >= 2) sb.append(count);
                    sb.append(str);
                    str = compare;
                    count = 1;
                }
            }
            sb.append(str);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
    public static void main(String[] args) {
        String s1 = "aabbaccc";
        String s2 = "ababcdcdababcdcd";
        String s3 = "abcabcdede";
        String s4 = "abcabcabcabcdededededede";
        String s5 = "xababcdcdababcdcd";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
        System.out.println(solution(s5));
    }
}
