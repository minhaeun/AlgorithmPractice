package SWEA.recursion.SWEA1218;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1218 {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("./src/SWEA/recursion/SWEA1218/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        for(int tc = 1; tc <= T; tc++){
            StringBuilder sb = new StringBuilder();
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();
            Stack<Character> stack = new Stack<Character>();
            int i ;
            for(i = 0; i < len; i++){
                if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '<'){
                    stack.push(str.charAt(i));
                }else{
                    if(stack.isEmpty()){
                        break;
                    }else{
                        char top = stack.pop();
                        if((str.charAt(i) == ')' && top == '(') || (str.charAt(i) == '}' && top == '{') || (str.charAt(i) == ']' && top == '[') || (str.charAt(i) == '>' && top == '<'))  continue;
                        else{
                            break;
                        }

                    }
                }
            }
            sb.append("#").append(tc).append(" ");
            if(i == len && (stack.isEmpty())){
                sb.append("1");
                System.out.println(sb);
            }else{
                sb.append("0");
                System.out.println(sb);
            }

        }
    }
}
