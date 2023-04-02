package baekjoon.boj1032;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj1032 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1032/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
        }

        boolean flag;
        for(int i = 0; i < arr[0].length(); i++){
            flag = false;
            for(int j = 0; j < N - 1; j++){
                if(arr[j].charAt(i) != arr[j + 1].charAt(i)){
                    flag = true;
                    break;
                }
            }
            if(flag) sb.append("?");
            else sb.append(arr[0].charAt(i));
        }

        System.out.println(sb);
    }
}
