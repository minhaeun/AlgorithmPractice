
package baekjoon.boj15684;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15684 {
    static int N, M, H, min;
    static boolean[][] map;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj15684/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new boolean[H + 1][N + 1];
        min = 4;
        for(int m = 0; m < M; m++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
        }

        int total = 0, count;
        for(int i = 1; i <= N; i++){
            count = 0;
            for(int j = 1; j <= H; j++){
                if(map[j][i]) count++;
            }
            if(count % 2 != 0)  total++;
        }
        if(total > 3){
            System.out.println(-1);
            return;
        }
        dfs(0, 1, 1);
        if(min <= 3) System.out.println(min);
        else System.out.println(-1);


    }

    public static void dfs(int count, int h, int n){
        if(min <= count)    return;
        if(check()){
            min = count;
            return;
        }
        int j = n;
        for(int i = h; i <= H; i++){
            if(i != h)  j = 1;
            for(; j < N; j++){
                if(map[i][j] || map[i][j-1])    continue;
                map[i][j] = true;
                dfs(count+1, i, j);
                map[i][j] = false;
            }
        }
    }

    public static boolean check(){
        for(int start = 1; start <= N; start++){
            int j = start;  // 세로
            for(int i = 1; i <= H; i++){
                if(map[i][j]) j++;  // 다음 세로줄과 연결
                else if(map[i][j-1]) j--;   // 이전 세로줄과 연결
            }
            if(start != j)  return false;
        }
        return true;
    }
}
