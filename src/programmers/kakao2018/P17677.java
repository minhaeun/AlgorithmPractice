package programmers.kakao2018;

import java.util.ArrayList;
import java.util.Collections;

public class P17677 {
    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> inter = new ArrayList<>();

        for(int i = 0; i < str1.length() - 1; i++){
            char a = str1.charAt(i);
            char b = str1.charAt(i + 1);

            if(Character.isLetter(a) && Character.isLetter(b)){
                String str = a + Character.toString(b);
                list1.add(str);
            }
        }
        for(int i = 0; i < str2.length() - 1; i++){
            char a = str2.charAt(i);
            char b = str2.charAt(i + 1);

            if(Character.isLetter(a) && Character.isLetter(b)){
                String str = a + Character.toString(b);
                list2.add(str);
            }
        }

        Collections.sort(list1);
        Collections.sort(list2);

        for(String s : list1){
            if(list2.remove(s)) inter.add(s);
            union.add(s);
        }
        for(String s : list2) union.add(s);

        double j = 0;
        if(union.size() == 0) j = 1;
        else j = (double) inter.size() / (double) union.size();

        return (int) (j * 65536);
    }
    public static void main(String[] args) {
        String str1 = "FRANCE", str2 = "french";
        String str3 = "handshake", str4 = "shake hands";
        String str5 = "aa1+aa2", str6 = "AAAA12";
        String str7 = "E=M*C^2", str8 = "e=m*c^2";

        System.out.println(solution(str1, str2));
        System.out.println(solution(str3, str4));
        System.out.println(solution(str5, str6));
        System.out.println(solution(str7, str8));
    }
}
