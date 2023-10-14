package baekjoon.boj5568;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Boj5568 {
    public static int N, K;
    public static String arr[];
    public static ArrayList<String> list;
    public static boolean visited[];
    public static Set<String> set;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj5568/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new String[N];
        visited = new boolean[N];
        list = new ArrayList<>(K);
        set = new HashSet<>();

        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
        }
        select(0);
        System.out.println(set.size());
    }
    public static void select(int count){
        if(count == K){
            String str = "";
            for(String s : list){
                str += s;
            }
            set.add(str);
            return;
        }
        for(int i = 0; i < N; i++){
            if(visited[i])  continue;
            visited[i] = true;
            list.add(arr[i]);
            select(count + 1);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }


}
