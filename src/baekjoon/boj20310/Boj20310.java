package baekjoon.boj20310;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj20310 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj20310/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int strLen = str.length();
        int[] visited = new int[strLen];

        for(int i = 0; i < strLen; i++){
            if(visited[i] != 0)  continue;
            char ch = str.charAt(i);
            if(ch == '0'){
                visited[i] = 1;
                for(int j = strLen - 1; j >= 0; j--){
                    if(str.charAt(j) == ch && visited[j] == 0){
                        visited[j] = 2;
                        break;
                    }
                }
            }else{
                visited[i] = 2;
                for(int j = strLen - 1; j >= 0; j--){
                    if(str.charAt(j) == ch && visited[j] == 0){
                        visited[j] = 1;
                        break;
                    }
                }
            }
        }

        for(int i = 0; i < strLen; i++){
            if(visited[i] == 1) sb.append(str.charAt(i));
        }
        System.out.println(sb);

    }
}
