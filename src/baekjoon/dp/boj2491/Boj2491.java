package baekjoon.dp.boj2491;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2491 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("baekjoon/dp/boj2491/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int max = 1;
        int incCnt = 1;
        int decCnt = 1;

        int num = Integer.parseInt(st.nextToken());
        N--;
        while(N-- > 0){
            int cur = Integer.parseInt(st.nextToken());

            if(cur == num){
                incCnt++;
                decCnt++;
                continue;
            }

            if(cur < num){
                max = Math.max(max, incCnt);
                incCnt = 1;
            }else{
                incCnt++;
            }

            if(cur > num){
                max = Math.max(max, decCnt);
                decCnt = 1;
            }else{
                decCnt++;
            }

            num = cur;
        }

        max = Math.max(max, Math.max(incCnt, decCnt));
        System.out.println(max);
    }
}
