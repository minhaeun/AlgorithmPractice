package baekjoon.boj5525;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj5525 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj5525/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int S = Integer.parseInt(br.readLine());
        char[] text = br.readLine().toCharArray();


        ArrayList<Integer> arrayList = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < S; i++){
            if(text[i] == 'I')   arrayList.add(i);
        }

        int total = 0;
        for(int i = 1; i < arrayList.size(); i++){
            if(arrayList.get(i) - arrayList.get(i-1) == 2){
                count++;
            }else{
                count = 0;
            }
            if(count >= N)  total++;
        }
        System.out.println(total);




    }
}
