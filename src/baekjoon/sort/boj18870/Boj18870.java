package baekjoon.sort.boj18870;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj18870 {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/sort/boj18870/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] nums = new int[N];


        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] clone = nums.clone();
        Arrays.sort(clone);

        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for(int i = 0; i < N; i++){
            if(!map.containsKey(clone[i]))   map.put(clone[i], count++);
        }



        for(int value : nums){
            sb.append(map.get(value)).append(" ");
        }
        System.out.println(sb.toString());

    }
}
