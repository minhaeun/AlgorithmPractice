package baekjoon.binary_search.boj6236;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj6236 {
    static int N, M;
    static int[] costs;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon/binary_search/boj6236/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        costs = new int[N];
        int low = 1, high = (int) 1e9, answer = 0;

        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(br.readLine());
            low = Math.max(low, costs[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (getCnt(mid) > M) {
                low = mid + 1;
            } else {
                answer = mid;
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }

    static int getCnt(int mid) {
        int remain = mid;
        int cnt = 1;

        for (int i = 0; i < N; i++) {
            if (remain - costs[i] < 0) {
                remain = mid;
                cnt++;
            }

            remain -= costs[i];
        }

        return cnt;
    }





}
