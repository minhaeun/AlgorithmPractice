package baekjoon.sort.boj2108;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Boj2108 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/sort/boj2108/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[n];
        int[] check = new int[8001];
        int max = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            check[arr[i] + 4000]++;
        }
        System.out.println((int)Math.round((double)sum/n));
        Arrays.sort(arr);
        System.out.println(arr[n/2]);
        for(int i = 0; i < 8001; i++){
            if(check[i] >= max){
                max = check[i];
            }
        }
        for(int i = 0; i < 8001; i++){
            if(check[i] == max){
                list.add(i - 4000);
            }
        }
        if(list.size() == 1){
            System.out.println(list.get(0));
        }
        else{
            Collections.sort(list);
            System.out.println(list.get(1));
        }
        System.out.println(Math.abs(arr[arr.length - 1] - arr[0]));
    }

}
