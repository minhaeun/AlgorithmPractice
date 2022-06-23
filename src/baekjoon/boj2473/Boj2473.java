package baekjoon.boj2473;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2473 {
    static int N;
    static long arr[], answer[];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj2473/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        answer = new long[3];
        for (int i = 0; i < N - 2; i++) {
            int low = i + 1;
            int high = N - 1;

            while (low < high) {
                long value = arr[low] + arr[high] + arr[i];
                long tmp = Math.abs(value);
                if (min > tmp) {
                    min = tmp;
                    answer[0] = arr[i];
                    answer[1] = arr[low];
                    answer[2] = arr[high];
                }

                if (value < 0) low += 1;
                else if (value == 0) break;
                else high -= 1;

            }

        }

        for (long value : answer) {
            sb.append(value).append(" ");
        }
        System.out.println(sb.toString().trim());


    }
}
