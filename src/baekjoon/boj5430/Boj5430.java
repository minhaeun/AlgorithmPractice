package baekjoon.boj5430;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Boj5430 {
    static int T, N, arr[];
    static char[] P;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj5430/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String tmp = br.readLine();
            N = Integer.parseInt(br.readLine());
            String str = br.readLine().replace("[", "");
            str = str.replace("]", "");
            if (str.isEmpty()) {
                if (tmp.contains("D")) {
                    sb.append("error\n");
                    continue;
                } else {
                    sb.append("[]\n");
                    continue;
                }

            }
            P = tmp.toCharArray();
            StringTokenizer st = new StringTokenizer(str, ",");
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int dir = 1, start = 0, end = N - 1;
            for (char ch : P) {
                switch (ch) {
                    case 'R':
                        dir = dir * -1;
                        break;
                    case 'D':
                        if (dir == 1) {
                            start++;
                        } else {
                            end--;
                        }
                        break;
                }
            }

            if (start > end) {
                if (start - 1 == end) {
                    sb.append("[]\n");
                } else sb.append("error\n");
            } else {
                sb.append("[");
                if (dir == 1) {
                    while (start <= end) {
                        sb.append(arr[start]).append(",");
                        start++;
                    }
                } else {
                    while (end >= start) {
                        sb.append(arr[end]).append(",");
                        end--;
                    }
                }
                sb.deleteCharAt(sb.lastIndexOf(","));
                sb.append("]\n");
            }
        }
        System.out.println(sb.toString());
    }
}
