package programmers.zip;

public class P12951 {
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();

        boolean flag = true;
        for(int i = 0; i < len; i++){
            String ch = s.charAt(i) + "";
            if(ch.equals(" ")){
                flag = true;
                sb.append(" ");
                continue;
            }
            if(flag) sb.append(ch.toUpperCase());
            else sb.append(ch.toLowerCase());
            flag = false;

        }

        return sb.toString();
    }
    public static void main(String[] args) {
        String s1 = "3people unFollowed me";
        String s2 = "for the last week";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
    }
}
