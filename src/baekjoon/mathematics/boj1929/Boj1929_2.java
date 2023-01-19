package baekjoon.mathematics.boj1929;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1929_2 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/mathematics/boj1929/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] nums = new int[(end/8) + 1];
        Arrays.fill(nums, 255);
        nums[0>>3] &= ~(1<<(0&7));
        nums[1>>3] &= ~(1<<(1&7));

        int range = (int) Math.sqrt(end);

        for (int i = 2; i <= range; i++) {
            if ((nums[i>>3] & (1<<(i&7))) == 0 ) continue;
            for (int j = 2 * i; j <= end; j += i) {
                nums[j>>3] &= ~(1<<(j&7));
            }
        }

        for (int i = start; i <= end; i++) {
            if ((nums[i >> 3] & (1<<(i&7))) == 0) continue;
            sb.append(i).append("\n");
        }

        System.out.println(sb.toString());
    }
}
