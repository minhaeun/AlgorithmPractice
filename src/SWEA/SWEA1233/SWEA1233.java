package SWEA.SWEA1233;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1233 {
    static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/SWEA/SWEA1233/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = 10;

        for (int tc = 1; tc <= T; tc++) {
            StringBuilder sb = new StringBuilder();
            N = Integer.parseInt(br.readLine());
            int result = 1;
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String ch = st.nextToken();

                if (i <= N / 2 && Character.isDigit(ch.charAt(0)))  result = 0;

                if (i > N / 2 && !Character.isDigit(ch.charAt(0)))   result = 0;

            }
            sb.append("#").append(tc).append(" ").append(result);
            System.out.println(sb);
        }
    }
}
