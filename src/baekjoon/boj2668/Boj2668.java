package baekjoon.boj2668;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Boj2668 {
    public static int N, arr[], count;
    public static boolean visited[];
    public static ArrayList<Integer> list;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj2668/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList<>();

        for(int i = 1; i < N + 1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i < N + 1; i++){
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(int value : list){
            sb.append(value).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int start, int end){
        int value = arr[start];
        if(!visited[value]) {
            visited[value] = true;
            dfs(value, end);
            visited[value] = false;
        }
        if(value == end)    list.add(end);
    }
}
