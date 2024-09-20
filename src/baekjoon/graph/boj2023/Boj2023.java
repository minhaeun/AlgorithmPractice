package baekjoon.graph.boj2023;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj2023 {
    public static int N;
    public static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/graph/boj2023/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        System.out.println(sb);
    }

    public static void dfs(int num, int jarisu){
        if(jarisu == N){
            if(isPrime(num)){
                sb.append(num).append("\n");
            }
            return;
        }

        for(int i = 1; i <= 9; i++){
            if(i % 2 == 0)  continue;
            int newNum = num * 10 + i;
            if(isPrime(newNum)){
                dfs(newNum, jarisu + 1);
            }
        }
    }

    public static boolean isPrime(int n){

        for(int i = 2; i <= n/2; i++){
            if(n % i == 0)  return false;
        }
        return true;
    }
}
