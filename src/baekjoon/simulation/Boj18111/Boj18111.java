package baekjoon.simulation.Boj18111;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj18111 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj18111/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int answerTime = Integer.MAX_VALUE;
        int answerheight = -1;

        int map[][] = new int[N][M];
        int max = -1, min = answerTime;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int now = Integer.parseInt(st.nextToken());
                map[i][j] = now;
                if (now > max) max = now;
                if (now < min) min = now;
            }
        }

        for (int i = max; i >= min; i--) {
            int time = 0;
            int bag = B;
            int target = i;
            boolean isCompute = true;

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (map[y][x] == target) continue;
                    else {
                        int diff = Math.abs(target - map[y][x]);
                        if (target > map[y][x]) {
                            bag -= diff;
                            time += diff;
                        } else {
                            bag += diff;
                            time += (2 * diff);
                        }

                    }
                }
            }
            if (bag < 0) {
                continue;
            }
            if (isCompute && time < answerTime) {
                answerTime = time;
                answerheight = target;
            }
        }
        System.out.println(answerTime + " " + answerheight);
    }
}
