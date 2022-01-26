package baekjoon.mathematics.boj1978;

import java.io.*;
import java.util.StringTokenizer;

public class Boj1978 {


    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/mathematics/boj1978/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        while(st.hasMoreTokens()){
            boolean isPrime = true;
            int num = Integer.parseInt(st.nextToken());

            if(num == 1) continue;
            for(int i = 2; i <= Math.sqrt(num); i++){
                if(num % i == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) count++;
        }
        System.out.println(count);

    }
}
