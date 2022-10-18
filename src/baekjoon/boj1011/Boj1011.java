package baekjoon.boj1011;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1011 {
    static int start, end;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1011/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            int diff = end - start;

            int minNum = (int)Math.sqrt(diff);

            if(Math.sqrt(diff) == minNum ){
                sb.append(2*minNum -1).append("\n");
            }else if(minNum*minNum + minNum >= diff){
                sb.append(2*minNum).append("\n");
            }else{
                sb.append(2*minNum + 1).append("\n");
            }

        }
        System.out.println(sb.toString());

    }

}
