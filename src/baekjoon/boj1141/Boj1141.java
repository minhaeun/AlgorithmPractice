package baekjoon.boj1141;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Boj1141 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1141/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        int N = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            list.add(br.readLine());
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for(int i = 0; i < N; i++){
            boolean check = false;
            for(int j = i + 1; j < N; j++){
                String str1 = list.get(i);
                String str2 = list.get(j);
                if(str2.startsWith(str1)){
                    check = true;
                    break;
                }
            }
            if(!check)  count++;
        }
        System.out.println(count);
    }
}
