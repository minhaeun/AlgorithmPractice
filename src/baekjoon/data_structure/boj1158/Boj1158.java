package baekjoon.data_structure.boj1158;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1158 {
    public static int N, K;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj1158/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sb.append("<");

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) queue.offer(i);

        int count = 1;
        while(!queue.isEmpty()){
            if(count == K){
                sb.append(queue.poll()).append(", ");
                count = 1;
            }else{
                queue.offer(queue.poll());
                count++;
            }
        }

        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.deleteCharAt(sb.lastIndexOf(" "));
        sb.append(">");
        System.out.println(sb);

    }
}
