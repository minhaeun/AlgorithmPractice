package baekjoon.binary_search.boj1654;

import java.io.*;
import java.util.StringTokenizer;

public class Boj1654 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/binary_search/boj1654/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] len = new long[k];
        long max = 0;

        for (int i = 0; i < k; i++) {
            len[i] = Integer.parseInt(br.readLine());
            if (max < len[i]) {
                max = len[i];
            }
        }

        max++;

        long min = 0;
        long mid = 0;

        while (min < max) {
            mid = (max + min) / 2;
            int count = 0;

            for (int i = 0; i < len.length; i++) {
                count += (len[i] / mid);
            }

            if (count < n) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);


    }
}
