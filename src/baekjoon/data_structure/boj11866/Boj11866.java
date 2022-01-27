package baekjoon.data_structure.boj11866;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj11866 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/data_structure/boj11866/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            q.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');

        while(q.size() > 1){
            for(int i = 0; i < k - 1; i++){
                int value = q.poll();
                q.offer(value);
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append('>');
        System.out.println(sb);

    }
}
