package programmers.stackQueue;

public class P12909 {
    public static boolean solution(String s) {
        char[] arr = s.toCharArray();
        int len = s.length();

        int value = 0;
        for(int i = 0; i < len; i++){
            char ch = arr[i];
            if(ch == '(') value++;
            else value--;
            if(value < 0){
                return false;
            }
        }
        if(value != 0) return false;
        return true;
    }
    public static void main(String[] args) {
        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
    }
}
