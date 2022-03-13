package SWEA.simulation.SWEA1206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {    // 테스트 케이스 10개
            int N = Integer.parseInt(br.readLine());    // 가로 N <= 1000
            int[] m = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                m[i] = Integer.parseInt(st.nextToken());
            }
            int cnt = 0;
            for (int i = 2; i < N - 2; i++) {
                int min = 255;
                if (min > m[i] - m[i - 2]) min = m[i] - m[i - 2];
                if (min > m[i] - m[i - 2]) min = m[i] - m[i - 1];
                if (min > m[i] - m[i - 2]) min = m[i] - m[i + 1];
                if (min > m[i] - m[i - 2]) min = m[i] - m[i + 2];
                if (min >= 0) {    // 튀어나온 집이라면
                    cnt += min;
                    i += 2;
                }
            }

            sb.append("#").append(tc).append(" ").append(cnt).append("\n");

        }
        System.out.println(sb.toString());
    }

}
