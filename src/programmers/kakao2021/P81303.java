package programmers.kakao2021;

import java.util.Stack;
import java.util.StringTokenizer;

public class P81303 {
    public static String solution(int n, int k, String[] cmd) {
        int size = n;
        Stack<Integer> trash = new Stack<>();
        StringTokenizer st;
        for(String str : cmd){
            st = new StringTokenizer(str, " ");
            char ch = st.nextToken().charAt(0);
            if(ch == 'D'){
                int x = Integer.parseInt(st.nextToken());
                k += x;
            }else if(ch == 'U'){
                int x = Integer.parseInt(st.nextToken());
                k -= x;
            }else if(ch == 'C'){
                trash.push(k);
                size--;
                if(k == size) k--;
            }else{
                int value = trash.pop();
                if(value <= k) k++;
                size++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) sb.append("O");
        while(!trash.isEmpty()){
            int value = trash.pop();
            sb.insert(value, "X");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n1 = 8, k1 = 2, n2 = 8, k2 = 2;
        String[] cmd1 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        String[] cmd2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

        System.out.println(solution(n1, k1, cmd1));
        System.out.println(solution(n2, k2, cmd2));
    }
}
