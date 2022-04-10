
package baekjoon.boj3046;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3046 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj3046/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R1 = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        System.out.println(S*2 - R1);



    }
}
