package baekjoon.boj10431;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Boj10431 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj10431/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        TreeSet<Integer> treeSet;
        int[] arr;
        int P = Integer.parseInt(br.readLine());
        for(int p = 1; p <= P; p++) {
            st = new StringTokenizer(br.readLine(), " ");
            int T = Integer.parseInt(st.nextToken());
            treeSet = new TreeSet<>();
            arr = new int[20];
            int count = 0;

            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            treeSet.add(arr[0]);

            for (int i = 1; i < 20; i++) {
                for (int value : treeSet) {
                    if (value > arr[i]) count++;
                }
                treeSet.add(arr[i]);
            }

            sb.append(T).append(" ").append(count).append("\n");

        }
        System.out.println(sb);

    }
}
