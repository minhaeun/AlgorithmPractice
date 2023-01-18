package baekjoon.mathematics.boj1978;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1978_2 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/mathematics/boj1978/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int nums[] = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        boolean arr[] = new boolean[1001];
        arr[1] = true;
        for (int i = 2; i < 1001; i++) {
            if (arr[i]) continue;
            for (int j = i + 1; j < 1001; j++) {
                if (arr[j]) continue;
                if (j % i == 0) arr[j] = true;
            }
        }
        int count = 0;
        for (int num : nums) {
            if (!arr[num]) count++;
        }
        System.out.println(count);

    }
}
