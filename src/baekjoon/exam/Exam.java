package baekjoon.exam;

import java.io.*;
import java.util.*;

public class Exam {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/exam/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M1 = Integer.parseInt(st.nextToken());
            int M2 = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++){
                pq.add(Integer.parseInt(st.nextToken()));
            }

            ArrayList<Integer> arr1  = new ArrayList<>();
            ArrayList<Integer> arr2 = new ArrayList<>();

            while(!pq.isEmpty()){
                arr1.add(pq.poll());
                arr2.add(pq.poll());
            }
            int sum = 0;
            for(int i = 0; i < arr1.size(); i++){
                sum += arr1.get(i) * (i + 1);
                arr1.remove(i);
            }
            for(int i = 0; i < arr2.size(); i++){
                sum += arr2.get(i) * (i + 1);
            }

            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.println(sb.toString());




    }
}
