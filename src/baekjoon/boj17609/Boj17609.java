package baekjoon.boj17609;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj17609 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj17609/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            String str = br.readLine();

            sb.append(check(str, 0, 0, str.length()-1)).append("\n");

        }
        System.out.println(sb.toString());
    }

    public static int check(String str, int result, int start, int end){
        if(result == 2){
            return 2;
        }

        while(start <= end){
            if(str.charAt(start) == str.charAt(end)){
                start++;
                end--;
            }else{
                result = Math.min(check(str, result + 1, start + 1, end), check(str, result + 1, start, end-1));
                break;
            }
        }
        return result;
    }
}
