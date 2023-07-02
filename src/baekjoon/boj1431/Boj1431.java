package baekjoon.boj1431;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Boj1431 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1431/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        ArrayList<String> arrayList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            arrayList.add(br.readLine());
        }
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() < o2.length())   return -1;
                else if(o1.length() > o2.length())  return 1;
                else{
                    int sum1 = 0;
                    int sum2 = 0;
                    for(int i = 0; i < o1.length(); i++){
                        if(o1.charAt(i) >= '0' && o1.charAt(i) <= '9')  sum1 += (o1.charAt(i) - '0');
                        if(o2.charAt(i) >= '0' && o2.charAt(i) <= '9')  sum2 += (o2.charAt(i) - '0');
                    }
                    if(sum1 == sum2)    return o1.compareTo(o2);
                    else return Integer.compare(sum1, sum2);
                }
            }
        });
        for(String str : arrayList){
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}
