package baekjoon.boj11723;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj11723_2 {
    public static int M;
    public static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj11723/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            if(str.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                if(list.contains(num)) continue;
                list.add(num);
            }else if(str.equals("remove")){
                int num = Integer.parseInt(st.nextToken());
                int index = list.indexOf(num);
                if(index == -1) continue;
                list.remove(index);
            }else if(str.equals("check")){
                int num = Integer.parseInt(st.nextToken());
                if(list.contains(num)) sb.append(1).append("\n");
                else    sb.append(0).append("\n");
            }else if(str.equals("toggle")){
                int num = Integer.parseInt(st.nextToken());
                int index = list.indexOf(num);
                if(index != -1) list.remove(index);
                else    list.add(num);
            }else if(str.equals("all")){
                list = new ArrayList<>();
                for(int j = 1; j < 21; j++) list.add(j);
            }else{
                list = new ArrayList<>();
            }
        }
        System.out.println(sb);
    }

}
