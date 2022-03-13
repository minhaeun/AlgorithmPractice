package baekjoon.boj1697;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1697 {
    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj1697/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 수빈이가 더 큰 좌표에 있으면 걸어가야함
        if(N >= K){
            System.out.println(N-K);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        arr = new int[100001];

        // 지금 수빈이 위치
        queue.offer(N);
        arr[N] = 1;

        // BFS 탐색
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i = 0; i < 3; i++){
                int next;
                if(i == 0)  next = now - 1;
                else if(i == 1) next = now + 1;
                else    next = now * 2;

                if(next == K){
                    System.out.println(arr[now]);
                    return;
                }
                if(next < 0 || next > 100000)   continue;
                if(arr[next] == 0){
                    queue.offer(next);
                    arr[next] = arr[now] + 1;
                }
            }
        }



    }
}
