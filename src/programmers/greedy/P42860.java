package programmers.greedy;

public class P42860 {
    public static int solution(String name) {
        int answer = 0;

        int len = name.length();
        int move = len - 1;
        for(int i = 0; i < len; i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            int index = i + 1;
            while(index < len && name.charAt(index) == 'A'){
                index++;
            }
            move = Math.min(move, i * 2 + len - index);
            move = Math.min(move, (len - index) * 2 + i);
        }
        return answer + move;
    }
    public static void main(String[] args) {
        String name1 = "JEROEN";
        String name2 = "JAN";

        System.out.println(solution(name1));
        System.out.println(solution(name2));
    }
}
