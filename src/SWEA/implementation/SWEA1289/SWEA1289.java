package SWEA.implementation.SWEA1289;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1289 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("SWEA/implementation/SWEA1289/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            String str = br.readLine();
            sb = new StringBuilder();

            int before = 0;
            int count = 0;
            for(int i = 0; i < str.length(); i++){
                int current = str.charAt(i) - '0';
                if(before != current){
                    count++;
                    before = current;
                }
            }
            sb.append("#").append(tc).append(" ").append(count);
            System.out.println(sb);
        }
    }
}