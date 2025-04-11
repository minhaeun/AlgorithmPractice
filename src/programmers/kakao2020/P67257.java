package programmers.kakao2020;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class P67257 {
    public static Long max;
    public static int opLen;
    public static boolean[] visited;
    public static String op;
    public static ArrayList<String> list;
    public static long solution(String expression) {
        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(expression, "*|+|-", true);
        op = "";
        max = 0L;
        while(st.hasMoreTokens()){
            String token = st.nextToken();
            if(token.equals("*") && !op.contains("*")) op += "*";
            else if(token.equals("+") && !op.contains("+")) op += "+";
            else if(token.equals("-") && !op.contains("-")) op += "-";
            list.add(token);
        }
        opLen = op.length();
        visited = new boolean[opLen];
        choice( 0, "");
        return max;
    }
    public static void choice(int count, String str){
        if(count == opLen){
            Long value = check(str.toCharArray());
            max = Math.max(max, Math.abs(value));
            return;
        }
        for(int i = 0; i < opLen; i++){
            if(visited[i]) continue;
            visited[i] = true;
            choice(count + 1, str+op.charAt(i));
            visited[i] = false;
        }
    }
    public static Long check(char[] ops){
        ArrayList<String> tmpList = new ArrayList<>(list);
        int listSize = tmpList.size();
        for(int i = 0; i < opLen; i++){
            char op = ops[i];
            for(int j = 0; j < listSize; j++){
                if(tmpList.get(j).charAt(0) != op) continue;
                long value = cal(j, op, tmpList);
                for(int k = 0; k < 3; k++) tmpList.remove(j - 1);
                tmpList.add(j - 1, String.valueOf(value));
                listSize = tmpList.size();
                j--;
            }
        }
        return Long.parseLong(tmpList.get(0));
    }

    public static long cal(int index, char op, ArrayList<String> tmpList){
        long a = Long.parseLong(tmpList.get(index - 1));
        long b = Long.parseLong(tmpList.get(index + 1));
        return switch (op) {
            case '*' -> a * b;
            case '+' -> a + b;
            case '-' -> a - b;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        String expression1 = "100-200*300-500+20";
        String expression2 = "50*6-3*2";

        System.out.println(solution(expression1));
        System.out.println(solution(expression2));
    }
}
