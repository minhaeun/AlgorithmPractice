package programmers.kakao2018;

public class P17687 {
    public static String solution(int n, int t, int m, int p) {
        StringBuilder prep = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int count = t * m;
        int num = 0;
        while(prep.length() <= count){
            prep.append(Integer.toString(num++, n));
        }

        for(int i = p - 1; answer.length() < t; i += m){
            answer.append(prep.charAt(i));
        }

        return answer.toString().toUpperCase();
    }
    public static void main(String[] args) {
        int n1 = 2, t1 = 4, m1 = 2, p1 = 1;
        int n2 = 16, t2 = 16, m2 = 2, p2 = 1;
        int n3 = 16, t3 = 16, m3 = 2, p3 = 2;

        System.out.println(solution(n1, t1, m1, p1));
        System.out.println(solution(n2, t2, m2, p2));
        System.out.println(solution(n3, t3, m3, p3));

    }
}
