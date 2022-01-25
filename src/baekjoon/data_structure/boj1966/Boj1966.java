package baekjoon.data_structure.boj1966;

import java.io.*;
import java.net.StandardSocketOptions;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1966 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj1966/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= TC; ++tc){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] priority = new int[n];


            Queue<Integer> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                priority[i] = Integer.parseInt(st.nextToken());
                q.offer(i);
            }
            int count = 0;
            while(true){
                int max = 0;
                for(int i = 0; i < priority.length; i++){
                    if(max < priority[i]){
                        max = priority[i];
                    }
                }
                int element = q.poll();
                if(max == priority[element]){
                    count++;
                    priority[element] = 0;
                    if(m == element){
                        sb.append(count).append('\n');
                        break;
                    }
                }
                else{
                    q.offer(element);
                }

            }
        }
        System.out.print(sb);
    }
}
