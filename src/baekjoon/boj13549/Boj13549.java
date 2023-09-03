package baekjoon.boj13549;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj13549 {
    public static int[] delta = {-1, 1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj13549/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[100001];
        Arrays.fill(arr, 100001);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        arr[N] = 0;
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now == K)    break;

            for(int d = 0; d < 2; d++){
                int next = now + delta[d];

                if(next < 0 || next > 100000)   continue;
                if(arr[next] >= arr[now] + 1){
                    arr[next] = arr[now] + 1;
                    queue.offer(next);
                }
            }
            if(now * 2 > 100000)    continue;
            if(arr[now * 2] > arr[now]){
                arr[now * 2] = arr[now];
                queue.offer(now * 2);
            }
        }

        System.out.println(arr[K]);

    }
}
