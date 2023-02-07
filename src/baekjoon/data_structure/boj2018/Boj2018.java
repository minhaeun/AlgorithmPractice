package baekjoon.data_structure.boj2018;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj2018 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj2018/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 1;
        int count = 1;
        int start_index = 1;
        int end_index = 1;

        while(end_index != N){
            if(sum < N){
                end_index++;
                sum += end_index;
            }
            else if(sum > N){
                sum -= start_index;
                start_index++;
            }
            else{
                count++;
                end_index++;
                sum += end_index;
            }
        }

        System.out.println(count);

    }
}
