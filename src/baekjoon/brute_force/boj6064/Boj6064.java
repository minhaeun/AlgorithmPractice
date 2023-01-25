package baekjoon.brute_force.boj6064;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj6064 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/brute_force/boj6064/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int a = x;
            int b = x;
            while(a > M)    a -= M;
            while(b > N)    b -= N;
            int count = x;

            while(true){
                if(a == x && b == y)    break;
                count += M;
                a += M;
                b += M;
                while(a > M)    a -= M;
                while(b > N)    b -= N;
                if(count > M * N){
                    count = -1;
                    break;
                }
            }
            sb.append(count).append("\n");

        }
        System.out.println(sb);


    }
}
