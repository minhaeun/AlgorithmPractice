package baekjoon.simulation.boj1244;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1244_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/simulation/boj1244/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int switchNum = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[switchNum + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= switchNum; i++){
            int status = Integer.parseInt(st.nextToken());
            if(status == 1) arr[i] = true;
        }

        int studentNum = Integer.parseInt(br.readLine());
        for(int n = 0; n < studentNum; n++){
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(gender == 1){
                int limit = switchNum / num;
                for(int i = 1; i <= limit; i++){
                    arr[num * i] = !arr[num * i];
                }
            }else{
                int limit = Math.min(num - 1, switchNum - num);
                arr[num] = !arr[num];
                for(int i = 1; i <= limit; i++){
                    if(arr[num - i] == arr[num + i]){
                        arr[num - i] = !arr[num - i];
                        arr[num + i] = !arr[num + i];
                    }else break;
                }
            }
        }
        for(int i = 1; i < switchNum + 1; i++){
            if(i % 20 == 1 && i > 20) sb.append("\n");
            if(arr[i])  sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }
}
