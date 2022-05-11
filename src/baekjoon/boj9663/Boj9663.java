package baekjoon.boj9663;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj9663 {
    static int N, answer;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj9663/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dfs(0);

        System.out.println(answer);
    }

    static boolean adjacent(int x){
        for(int i = 0; i < x; i++){
            if(arr[x] == arr[i] || Math.abs(arr[x] - arr[i]) == x-i)    return false;
        }
        return true;
    }

    static void dfs(int count){
        if(count == N){
            answer++;
            return;
        }

        for(int i = 0; i < N; i++){
            arr[count] = i;
            if(adjacent(count)) dfs(count+1);
        }

    }

}
