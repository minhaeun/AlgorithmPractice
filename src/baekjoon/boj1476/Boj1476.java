package baekjoon.boj1476;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1476 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1476/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e = 1, s = 1, m = 1;
        int count = 1;
        while(true){
            if(e == E && s == S && m == M)  break;
            e++;
            s++;
            m++;
            if(e == 16) e = 1;
            if(s == 29) s = 1;
            if(m == 20) m = 1;
            count++;
        }
        System.out.println(count);

    }
}
