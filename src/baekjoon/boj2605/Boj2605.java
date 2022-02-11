package baekjoon.boj2605;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj2605 {
    static int N;
    static int[] sequence;
    static ArrayList<Integer> arrayList;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj2605/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        sequence = new int[N + 1];
        arrayList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        arrayList.add(0);
        for(int i = 1; i <= N; i++){
            arrayList.add(i);
        }

        for(int i = 2; i < sequence.length; i++){
            int value = arrayList.get(i);
            arrayList.remove(i);
            arrayList.add(i - sequence[i], value);
        }

        for(int i = 1; i <= N; i++){
            sb.append(arrayList.get(i)).append(" ");
        }
        System.out.println(sb);

    }
}
