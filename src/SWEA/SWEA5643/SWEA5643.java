package SWEA.SWEA5643;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5643 {
    static int N, M;
    static int[][] adj;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/SWEA/SWEA5643/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;


        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());    // 학생들의 수
            M = Integer.parseInt(br.readLine());    // 두 학생의 키를 비교한 횟수
            adj = new int[N + 1][N + 1];

            // 인접행렬 만들기
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a][b] = 1;
            }

            int totalCount = 0;
            for (int i = 1; i <= N; i++) {
                // 큰사람 찾기
                int bigCount = big(i);
                //System.out.println("bigCount : " + bigCount);
                // 작은사람 찾기
                int smallCount = small(i);
                //System.out.println("smallCount : " + smallCount);
                // 큰사람 + 작은사람 = N-1 일 경우 count 증가

                if (bigCount + smallCount == N - 1) {
                    totalCount++;
                }
            }

            sb.append("#").append(tc).append(" ").append(totalCount).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int big(int num) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        queue.add(num);
        visit[num] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (adj[node][i] != 1 || visit[i]) continue;
                queue.add(i);
                visit[i] = true;
                count++;
            }
        }
        return count;
    }

    public static int small(int num) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];
        int count = 0;
        queue.add(num);
        visit[num] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (adj[i][node] != 1 || visit[i]) continue;
                queue.offer(i);
                visit[i] = true;
                count++;
            }
        }
        return count;
    }

}
