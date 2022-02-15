package baekjoon.brute_force.boj20361;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20361 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        System.setIn(new FileInputStream("baekjoon/brute_force/boj20361/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int N, X, K;
        boolean[] cups;

        int from = 0, to = 0;
        st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());    // 종이컵의 수
        X = Integer.parseInt(st.nextToken());    // 간식이 들어있는 종이컵 위치 (왼쪽에서)
        K = Integer.parseInt(st.nextToken());    // 컵의 위치를 바꾸는 횟수

        cups = new boolean[N + 1];
        cups[X] = true;        // 간식이 들어있는 종이컵

        int a = X, b = 0;

        for (int k = 0; k < K; k++) {    // K만큼 반복문 돌리기
            st = new StringTokenizer(br.readLine(), " ");
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            if (cups[from] != cups[to]) {    // 간식이 있으면
                cups[from] = !cups[from];
                cups[to] = !cups[to];
                a = from;
                b = to;

            }
        }
        if (cups[a] == true) sb.append(a);
        else sb.append(b);
        System.out.println(sb);


    }


}
