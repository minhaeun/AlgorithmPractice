package baekjoon.boj2531;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2531 {

    public static void main(String[] args) throws Exception{
      System.setIn(new FileInputStream("./src/baekjoon/boj2531/input.txt"));
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      int N = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int[] arr = new int[N];

      for(int i = 0; i < N; i++){
        arr[i] = Integer.parseInt(br.readLine());
      }
      Queue<Integer> queue = new LinkedList<>();

      int[] check = new int[d + 1];

      int count = 0, max = 0;
      for(int i = 0; i < k; i++){
          int value = arr[i];
          check[value]++;
          if(check[value] == 1) count++;
          queue.offer(value);
      }
      if(max < count){
          max = count;
          if(check[c] == 0)   max++;
      }

      for(int i = k; i < N + k - 1; i++){
          int index = i % N;
          int value = queue.poll();
          if(check[value] == 1) count--;
          check[value]--;
          queue.offer(arr[index]);
          check[arr[index]]++;
          if(check[arr[index]] == 1) count++;
          if(max <= count){
              max = count;
              if(check[c] == 0)   max++;
          }
      }
        System.out.println(max);

    }
}
