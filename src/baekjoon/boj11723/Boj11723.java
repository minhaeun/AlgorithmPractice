package baekjoon.boj11723;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj11723 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj11723/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();

            if(str.equals("add")){
                int x = Integer.parseInt(st.nextToken());
                if(arrayList.indexOf(x) == -1)  arrayList.add(x);
            }else if(str.equals("remove")){
                int x = Integer.parseInt(st.nextToken());
                int index = arrayList.indexOf(x);
                if(index != -1) arrayList.remove(index);
            }else if(str.equals("check")){
                int x = Integer.parseInt(st.nextToken());
                int index = arrayList.indexOf(x);
                if(index == -1) sb.append(0).append("\n");
                else sb.append(1).append("\n");
            }else if(str.equals("toggle")){
                int x = Integer.parseInt(st.nextToken());
                int index = arrayList.indexOf(x);
                if(index == -1) arrayList.add(x);
                else arrayList.remove(index);
            }else if(str.equals("all")){
                arrayList = new ArrayList<>();
                for(int j = 1; j <= 20; j++){
                    arrayList.add(j);
                }
            }else{  // empty
                arrayList = new ArrayList<>();
            }
        }
        System.out.println(sb);
    }
}
