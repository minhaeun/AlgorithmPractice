package SWEA.SWEA1225;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 {
    static int x;
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/SWEA/SWEA1225/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = 10;
        for(int tc = 1; tc <= T; tc++){
            StringBuilder sb = new StringBuilder();
            x = Integer.parseInt(br.readLine());
            queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < 8; i++){
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            OUTER : while(true){
                for(int i = 1; i <= 5; i++){
                    int front = queue.poll() - i;
                    if(front <= 0){
                        queue.offer(0);
                        break OUTER;
                    }
                    queue.offer(front);
                }
            }
            sb.append("#").append(tc).append(" ");
            while(!queue.isEmpty())   sb.append(queue.poll()).append(" ");
            System.out.println(sb);
        }
    }

}
