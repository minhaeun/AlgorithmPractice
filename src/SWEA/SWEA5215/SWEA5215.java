package SWEA.SWEA5215;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5215 {
    static int N;
    static int L;
    static int[][] arr;
    static int max;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/SWEA/SWEA5215/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = null;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            sb = new StringBuilder();
            arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());   //score
                arr[i][1] = Integer.parseInt(st.nextToken());   //calorie
            }
            max = 0;
            generateSubset(0, 0, 0);
            sb.append("#").append(tc).append(" ").append(max);
            System.out.println(sb);
        }
    }

    public static void generateSubset(int count, int score, int calorie) {

        if (calorie > L) {
            return;     // 칼로리가 1000이 넘었을 경우
        }

        if (calorie <= L) {              // 칼로리가 1000이하일 경우
            if (score > max) max = score;
        }

        if (count == N) return;     // 마지막 원소까지 선택
        // 현재 원소 선택
        generateSubset(count + 1, score + arr[count][0], calorie + arr[count][1]);

        // 현재 원소 비선택
        generateSubset(count + 1, score, calorie);

    }
}
