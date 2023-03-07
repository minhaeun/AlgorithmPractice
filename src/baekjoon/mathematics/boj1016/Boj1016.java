package baekjoon.mathematics.boj1016;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1016 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/mathematics/boj1016/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] arr = new boolean[(int) (max - min + 1)];

        for(long i = 2; i * i <= max; i++){
            long pow = i * i;
            long index = min / pow;
            if(min % pow != 0){
                index++;
            }
            for(long j = index; pow * j <= max; j++){
                arr[(int)((j * pow) - min)] = true;
            }
        }

        int count = 0;
        for(int i = 0; i <= max - min; i++){
            if(!arr[i]) count++;
        }
        System.out.println(count);





    }
}
