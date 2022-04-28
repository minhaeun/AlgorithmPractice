package baekjoon.boj5557;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj5557 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj5557/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        // 2^63 - 1이니까 long
        long[][] dp = new long[N + 1][21];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 시작 숫자에 해당하는 인덱스 위치 값 + 1
        dp[1][arr[1]]++;

        // 맨 마지막 숫자는 결과니까 맨 마지막 전까지 반복
        for (int i = 2; i < N; i++) {
            for (int j = 0; j <= 20; j++) {
                // 이전 계산 결과 숫자에 해당하는 인덱스가 0보다 크다면 이전에 계산된 수
                if (dp[i - 1][j] > 0) {
                    // 이전 숫자 j와 현재 숫자 arr[i]와 더했을 때 20보다 작다면
                    if (arr[i] + j <= 20) {
                        // 현재 게산된 결과에 해당 인덱스값에 이전 숫자까지의 결과 더하기
                        dp[i][arr[i] + j] += dp[i - 1][j];
                    }
                    // 이전 숫자에서 빼야하므로 j에다가 현재 숫자 빼기
                    // 이전의 숫자 j와 현재 숫자 arr[i]를 뺐을 때 0보다 크다면
                    if (j - arr[i] >= 0) {
                        // 현재 게산된 결과에 해당 인덱스 값에 이전 숫자까지의 결과 더하기
                        dp[i][j - arr[i]] += dp[i - 1][j];

                    }
                }
            }
        }
        // 마지막 숫자가 나온 횟수 출력
        System.out.println(dp[N - 1][arr[N]]);


    }
}
