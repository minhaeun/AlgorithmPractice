package baekjoon.greedy.boj1744;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Boj1744 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/greedy/boj1744/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();

        int zeroCount = 0, oneCount = 0;
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0) zeroCount++;
            else if(num == 1)   oneCount++;
            else if(num > 1)    plus.offer(num);
            else minus.offer(num);
        }

        int sum = 0;
        while(!minus.isEmpty() && minus.size() != 1){
            int num1 = minus.poll();
            int num2 = minus.poll();
            sum += num1 * num2;
        }
        if(minus.size() == 1){
            if(zeroCount == 0){
                sum += minus.poll();
            }
        }

        while(!plus.isEmpty() && plus.size() != 1){
            int num1 = plus.poll();
            int num2 = plus.poll();
            sum += num1 * num2;
        }
        if(plus.size() == 1){
            sum += plus.poll();
        }

        sum += oneCount;
        System.out.println(sum);




    }
}
