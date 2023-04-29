package baekjoon.boj1526;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1526 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1526/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        while(true){
            boolean check = true;
            for(int i = 0; i <N.length(); i++){
                if(N.charAt(i) != '4' && N.charAt(i) != '7'){
                    check = false;
                    break;
                }
            }
            if(check)   break;
            else N = String.valueOf(Integer.parseInt(N) - 1);
        }
        System.out.println(N);
    }
}
