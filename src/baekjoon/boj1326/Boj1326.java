package baekjoon.boj1326;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1326 {
    public static int N;
    public static int[] arr, visit;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1326/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(BFS(a, b));
    }

    private static int BFS(int a, int b) {
        visit = new int[N + 1];
        Arrays.fill(visit, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { a, 0 });
        visit[a] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == b) {
                return now[1];
            }

            for (int i = now[0]; i > 0; i -= arr[now[0]]) {
                if (now[1] + 1 < visit[i]) {
                    visit[i] = now[1] + 1;
                    queue.add(new int[] { i, now[1] + 1 });
                }
            }
            for (int i = now[0]; i <= N; i += arr[now[0]]) {
                if (now[1] + 1 < visit[i]) {
                    visit[i] = now[1] + 1;
                    queue.add(new int[] { i, now[1] + 1 });
                }
            }
        }

        return -1;
    }
}