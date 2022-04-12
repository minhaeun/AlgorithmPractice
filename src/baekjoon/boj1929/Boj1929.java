package baekjoon.boj1929;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1929 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj1929/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        boolean[] nums = new boolean[end + 1];
        nums[0] = true;
        nums[1] = true;
        int range = (int) Math.sqrt(end);

        for (int i = 2; i <= range; i++) {
            if (nums[i]) continue;
            for (int j = 2 * i; j <= end; j += i) {
                nums[j] = true;
            }
        }

        for (int i = start; i <= end; i++) {
            if (nums[i]) continue;
            sb.append(i).append("\n");
        }

        System.out.println(sb.toString());
    }
}
