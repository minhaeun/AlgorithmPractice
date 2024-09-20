package baekjoon.boj21921;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj21921_2 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj21921/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        st = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        for(int i = 0; i < X; i++){
            int value = Integer.parseInt(st.nextToken());
            queue.offer(value);
            max += value;
        }

        int sum = max, count = 1;
        for(int i = X; i < N; i++){
            int pollValue = queue.poll();
            sum -= pollValue;
            int value = Integer.parseInt(st.nextToken());
            queue.offer(value);
            sum += value;
            if(sum > max){
                max = sum;
                count = 1;
            }
            else if(sum == max)  count++;
        }
        if(max == 0)    sb.append("SAD");
        else{
            sb.append(max).append("\n").append(count);
        }
        System.out.println(sb);





    }
}
