package baekjoon.boj1021;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj1021 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1021/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        LinkedList<Integer> deque = new LinkedList<>();

        int count = 0;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++){
            deque.offer(i);
        }

        int[] seq = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            int target_idx = deque.indexOf(seq[i]);
            int half_idx;
            if(deque.size() % 2 == 0){
                half_idx = deque.size() / 2 - 1;
            }else{
                half_idx = deque.size() / 2;
            }

            if(target_idx <= half_idx){
                for(int j = 0; j < target_idx; j++){
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            }else{
                for(int j = 0; j < deque.size() - target_idx; j++){
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);



    }
}
