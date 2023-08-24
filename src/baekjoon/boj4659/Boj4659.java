package baekjoon.boj4659;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj4659 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj4659/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if(str.equals("end"))   break;

            char[] ch = str.toCharArray();
            int len = ch.length;

            boolean flag = false;
            for(int i = 0; i < len; i++){
                if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u'){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                sb.append("<").append(str).append("> is not acceptable.\n");
                continue;
            }

            flag = false;
            for(int i = 1; i < len - 1; i++){
                int count1 = 0, count2 = 0;
                for(int j = -1; j < 2; j++){
                    if(ch[i + j] == 'a' || ch[i + j] == 'e' || ch[i + j] == 'i' || ch[i + j] == 'o' || ch[i + j] == 'u'){
                        count1++;
                    }else count2++;
                }
                if(count1 >= 3 || count2 >= 3){
                    flag = true;
                    sb.append("<").append(str).append("> is not acceptable.\n");
                    break;
                }
            }

            if(flag)    continue;

            flag = false;
            for(int i = 0; i < len -1; i++){
                if(ch[i] == ch[i + 1]){
                    if(ch[i] == 'e' || ch[i] == 'o')    flag = true;
                    else flag = false;
                    break;
                }
                flag = true;
            }
            if(flag || len == 1)    sb.append("<").append(str).append("> is acceptable.\n");
            else sb.append("<").append(str).append("> is not acceptable.\n");

        }
        System.out.println(sb);
    }
}
