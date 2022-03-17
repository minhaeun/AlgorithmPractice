package baekjoon.boj16953;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj16953 {
    static long a, b;
    static int count;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj16953/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        Queue<Long> queue = new LinkedList<>();
        queue.add(a);

         while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long cur = queue.poll();
                if(cur == b){
                    count++;
                    System.out.println(count);
                    return;
                }
                if (cur * 2 <= b)
                    queue.add(cur * 2);
                if (cur * 10 + 1 <= b)
                    queue.add(cur * 10 + 1);
            }
            count++;
        }

        System.out.println(-1);
    }
}
