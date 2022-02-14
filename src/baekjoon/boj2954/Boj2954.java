package baekjoon.boj2954;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2954 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj2954/Input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();
        char[] chars = br.readLine().toCharArray();

        int len = chars.length;
        for(int i = 0; i < len;){
            if(chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u'){
                sb.append(chars[i]);
                i += 3;
            }else{
                sb.append(chars[i]);
                i++;
            }

        }
        System.out.println(sb);
    }
}
