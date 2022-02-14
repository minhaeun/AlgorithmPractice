package baekjoon.boj20299;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20299 {

    static int N, S, M;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj20299/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());	// 동아리 수
        S = Integer.parseInt(st.nextToken());	// 팀원 3명의 능력 합
        M = Integer.parseInt(st.nextToken());	// 개인 능력치

        int count = 0; 		// 가입 가능한 동아리 수

        // 동아리 수 만큼 반복
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int sum = a + b + c;

            if(a < M || b < M || c < M)     continue;
            if(sum >= S){
                count++;
                sb.append(a).append(" ").append(b).append(" ").append(c).append(" ");
            }

        }

        System.out.println(count);
        System.out.println(sb);
    }

}
