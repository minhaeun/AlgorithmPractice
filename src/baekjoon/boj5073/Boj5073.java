package baekjoon.boj5073;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj5073 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj5073/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] arr = new int[3];

        while(true){
            st = new StringTokenizer(br.readLine()," ");
            arr[0] =  Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0)   break;

            Arrays.sort(arr);

            if(arr[2] >= arr[0] + arr[1])   sb.append("Invalid\n");
            else if(arr[0] == arr[1] && arr[1] == arr[2])   sb.append("Equilateral\n");
            else if(arr[0] != arr[1] && arr[1] != arr[2] && arr[2] != arr[0])   sb.append("Scalene\n");
            else sb.append("Isosceles\n");
        }

        System.out.println(sb);

    }
}
