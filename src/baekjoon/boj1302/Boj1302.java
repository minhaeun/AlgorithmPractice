package baekjoon.boj1302;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Boj1302 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1302/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(map.containsKey(str))    map.replace(str, map.get(str) + 1);
            else map.put(str, 1);
        }

        int max = 0;
        for(String a : map.keySet())    max = Math.max(max, map.get(a));

        ArrayList<String> arrayList = new ArrayList<>(map.keySet());
        Collections.sort(arrayList);
        for(String a : arrayList){
            if(map.get(a) == max){
                System.out.println(a);
                break;
            }
        }




    }
}
