package baekjoon.dp.boj12101;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj12101 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/dp/boj12101/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<String>[] list = new ArrayList[11];

        for(int i = 1; i < 11; i++){
            list[i] = new ArrayList<>();
        }

        list[1].add("1");
        list[2].add("11");
        list[2].add("2");
        list[3].add("111");
        list[3].add("12");
        list[3].add("21");
        list[3].add("3");

        for(int i = 4; i < 11; i++){
            for(String str : list[i - 1]){
                list[i].add(str + "1");
            }
            for(String str : list[i - 2]){
                list[i].add(str + "2");
            }
            for(String str : list[i - 3]){
                list[i].add(str + "3");
            }
        }

        Collections.sort(list[n]);

        if(k > list[n].size()) sb.append(-1);
        else{
            String ans = list[n].get(k - 1);

            for(int i = 0; i < ans.length() - 1; i++){
                sb.append(ans.charAt(i)).append("+");
            }
            sb.append(ans.charAt(ans.length() - 1));
        }
        System.out.println(sb);

    }
}
