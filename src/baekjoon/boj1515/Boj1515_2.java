package baekjoon.boj1515;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1515_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1515/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int index = 0;
        int ans = 0;
        while(ans++ <= 30000){
            String tmp = String.valueOf(ans);
            for(int i = 0; i < tmp.length(); i++){
                if(tmp.charAt(i) == str.charAt(index))  index++;
                if(index == str.length()){
                    System.out.println(ans);
                    return;
                }
            }
        }
    }
}
