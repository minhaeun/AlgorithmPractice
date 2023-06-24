package baekjoon.boj1515;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1515 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1515/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int pt = 0;
        int base = 0;
        while(base++ <= 30000){
            String tmp = String.valueOf(base);
            for(int i = 0; i < tmp.length(); i++){
                if(tmp.charAt(i) == s.charAt(pt))   pt++;
                if(pt == s.length()){
                    System.out.println(base);
                    return;
                }
            }
        }




    }
}
