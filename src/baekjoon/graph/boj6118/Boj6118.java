package boj6118;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj6118 {
	public static int N, M;
	public static ArrayList<Integer>[] arrayList;
	public static int visited[];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("./src/boj6118/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arrayList = new ArrayList[N + 1];
		visited = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			arrayList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arrayList[a].add(b);
			arrayList[b].add(a);
		}

		bfs(1);
		int max = 0, maxIndex = 0, count = 0;
		for (int i = 1; i <= N; i++) {
			if (max < visited[i]) {
				max = visited[i];
				maxIndex = i;
				count = 1;
			} else if (max == visited[i]) {
				count++;
			}
		}

		sb.append(maxIndex).append(" ").append(max - 1).append(" ").append(count);
		System.out.println(sb);

	}

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int value : arrayList[now]) {
				if (visited[value] != 0)	continue;
				visited[value] = visited[now] + 1;
				queue.offer(value);
			}
		}
	}
}
