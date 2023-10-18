package baekjoon.boj1703;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1703 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("baekjoon/boj1703/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int tree = 1;

            if(N == 0)  break;
            for(int i = 0; i < 2 * N; i++){
                int M = Integer.parseInt(st.nextToken());
                if(i % 2 == 0)  tree *= M;
                else tree -= M;
            }
            System.out.println(tree);
        }


    }
}
