package baekjoon.boj12927;

import java.io.*;

public class Boj12927 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj12927/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        boolean[] button = new boolean[str.length() + 1];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'Y') {
                button[i + 1] = true;
            }
        }
        int cnt = 0;


        for (int i = 0; i < button.length; i++) {
            if (button[i]) {
                int j = 1;
                while (i * j < button.length) {
                    button[i * j] = !button[i * j];
                    j++;
                }
                cnt++;
            }


        }

        System.out.println(cnt);
    }
}
