package baekjoon.simulation.boj14696;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14696 {
    static int N;
    static int[] a;
    static int[] b;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/simulation/boj14696/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());

            a = new int[5];
            for (int n = 0; n < num; n++) {
                a[Integer.parseInt(st.nextToken())]++;
            }
            st = new StringTokenizer(br.readLine(), " ");
            num = Integer.parseInt(st.nextToken());
            b = new int[5];
            for (int n = 0; n < num; n++) {
                b[Integer.parseInt(st.nextToken())]++;
            }
            int count = 0;
            for(int j = 4; j > 0; j--){
                if(a[j] == b[j]){
                    count++;
                    continue;
                }
                if(a[j] > b[j]) {
                    System.out.println("A");
                    break;
                }
                else{
                    System.out.println("B");
                    break;
                }
            }
            if(count == 4) System.out.println("D");

        }

    }
}
