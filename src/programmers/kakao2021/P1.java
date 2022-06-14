package programmers.kakao2021;


import java.util.Locale;

public class P1 {
    public static void main(String[] args) {

        String new_id1 = "...!@BaT#*..y.abcdefghijklm";
        String new_id2 = "z-+.^.";
        String new_id3 = "=.=";
        String new_id4 = "123_.def";
        String new_id5 = "abcdefghijklmn.p";
        System.out.println(solution(new_id1));
        System.out.println(solution(new_id2));
        System.out.println(solution(new_id3));
        System.out.println(solution(new_id4));
        System.out.println(solution(new_id5));
    }

    public static String solution(String new_id){
        StringBuilder sb = new StringBuilder();
        // 1단계
        new_id = new_id.toLowerCase(Locale.ROOT);
        char[] arr = new_id.toCharArray();
        // 2단계
        for(char ch : arr) {
            if (Character.isDigit(ch) || Character.isAlphabetic(ch) || ch == '.' || ch == '-' || ch == '_'){
                sb.append(ch);
            }
        }

        // 3단계
        new_id = sb.toString();
        while(new_id.contains("..")){
            new_id = new_id.replace("..", ".");
        }

        // 4단계
        if(!new_id.isBlank() && new_id.charAt(0) == '.') new_id = new_id.substring(1);
        if(!new_id.isBlank() && new_id.charAt(new_id.length()-1) == '.') new_id = new_id.substring(0, new_id.length()-1);


        // 5단계
        if(new_id.isBlank())    new_id = "a";

        // 6단계
        if(new_id.length() > 15){
            new_id = new_id.substring(0, 15);
            System.out.println("0~15 문자 : " + new_id + "      length : " + new_id.length());
            if(new_id.charAt(new_id.length()-1) == '.') new_id = new_id.substring(0, new_id.length()-1);
        }

        // 7단계
        sb.setLength(0);
        sb.append(new_id);
        while(sb.length() < 3){
            if(!new_id.isBlank())
                sb.append(new_id.charAt(new_id.length()-1));
        }
        return sb.toString();
    }



}
