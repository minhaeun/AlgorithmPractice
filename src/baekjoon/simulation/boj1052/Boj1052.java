package baekjoon.simulation.boj1052;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1052 {
    static int N, K, answer;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/simulation/boj1052/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        while(true){
            char[] binary = Integer.toBinaryString(N).toCharArray();
            int count = 0;

            for(int i = 0; i < binary.length; i++){
                if(binary[i] == '1')    count++;
            }

            if(count <= K){
                System.out.println(answer);
                break;
            }

            N++;
            answer++;
        }

    }
}
