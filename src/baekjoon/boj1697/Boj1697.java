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
    static int[] arr, min;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj1697/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[3];
        min = new int[100005];
        Arrays.fill(min, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        min[N] = 0;

        while(!queue.isEmpty()){
            int next = queue.poll();

            arr[0] = next - 1;
            arr[1] = next + 1;
            arr[2] = next * 2;

            for(int i = 0; i < 3; i++){
                if(arr[i] < 0 || arr[i] > 100000)   continue;
                if(min[arr[i]] == -1){
                    queue.add(arr[i]);
                    min[arr[i]] = min[next] + 1;
                }
            }
        }

        System.out.println(min[K]);

    }
}
