package baekjoon.boj12919;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj12919 {
    public static String S, T;
    public static int sLen;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj12919/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();
        sLen = S.length();

        if(solve(T)) System.out.println(1);
        else System.out.println(0);
    }

    public static boolean solve(String str){
        if(str.length() == sLen){
            if(str.equals(S))   return true;
            return false;
        }

        if(str.charAt(str.length() - 1) == 'A'){
            String tmp = str.substring(0, str.length() - 1);
            if(solve(tmp))  return true;
        }
        if(str.charAt(0) == 'B'){
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(1));
            if(solve(sb.reverse().toString()))  return true;
        }
        return false;
    }
}
