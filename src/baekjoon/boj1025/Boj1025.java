package baekjoon.boj1025;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1025 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1025/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[10][10];
        int result = -1;

        for (int i = 0; i < n; i++) {
            String s1 = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s1.charAt(j)));
            }
        }
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                for (int mi = -n; mi < n; ++mi)
                    for (int mj = -m; mj < m; ++mj)
                    {
                        if (mi == 0 && mj == 0) {
                            continue;
                        }

                        int t = 0;
                        int newI = i;
                        int newJ = j;
                        while (newI >= 0 && newI < n && newJ >= 0 && newJ < m)
                        {
                            t = 10 * t + arr[newI][newJ];
                            if (Math.abs(Math.sqrt(t) - (int)Math.sqrt(t)) < 1e-10){
                                result = Math.max(result, t);
                            }
                            newI += mi;
                            newJ += mj;
                        }

                    }
        System.out.println(result);
    }
}