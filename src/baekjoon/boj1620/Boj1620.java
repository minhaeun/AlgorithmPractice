package baekjoon.boj1620;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj1620 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1620/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map_int = new HashMap<>();
        HashMap<String, Integer> map_str = new HashMap<>();
        for(int i = 1; i <= n; i++){
            String name = br.readLine();
            map_int.put(i, name);
            map_str.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= m; i++){
            String tmp = br.readLine();
            if(isNum(tmp))  sb.append(map_int.get(Integer.parseInt(tmp)) + "\n");
            else sb.append(map_str.get(tmp) + "\n");
        }
        System.out.println(sb);
    }

    public static boolean isNum(String str){
        for(int i = 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i)))   return false;
        }
        return true;
    }
}
