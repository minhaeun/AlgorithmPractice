package baekjoon.boj1806;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1806 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1806/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();

        long sum = arr[0];
        int index = 1, min = Integer.MAX_VALUE;
        queue.offer(arr[0]);
        while(!queue.isEmpty()){
            if(sum < S){
                if(index >= N)  break;
                queue.offer(arr[index]);
                sum += arr[index];
                index++;
            }else{
                min = Math.min(min, queue.size());
                int value = queue.poll();
                sum -= value;

            }
        }

        if(min == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(min);


    }
}
