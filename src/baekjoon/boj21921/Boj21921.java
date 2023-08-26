package baekjoon.boj21921;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj21921 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj21921/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        Queue<Integer> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0, count = 1;
        for(int i = 0; i < X; i++){
            queue.offer(arr[i]);
            sum += arr[i];
        }
        int max = sum;
        for(int i = X; i < N; i++){
            sum -= queue.poll();
            queue.offer(arr[i]);
            sum += arr[i];
            if(max < sum){
                max = sum;
                count = 1;
            }else if(max == sum)    count++;
        }
        if(max == 0)    sb.append("SAD");
        else    sb.append(max).append("\n").append(count);
        System.out.println(sb);
    }
}
