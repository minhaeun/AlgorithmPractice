package baekjoon.boj2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Boj2529_v2 {
    static boolean[] visited = new boolean[10];
    static String[] array = new String[10];// K의 범위는 2~9
    static ArrayList<String> list = new ArrayList<String>();
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            array[i] = st.nextToken();
        }
        for (int i = 0; i <= 9; i++) {
            visited[i] = true;
            dfs(0, i, i + "");
        }
//		for(String x: list)
//			System.out.println(x);
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    private static void dfs(int count, int index, String str) {
        if (count == k) {
            list.add(str);
            visited[index] = false;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (visited[i])
                continue;
            if (index == i)
                continue;
            if (array[count].equals(">")) {
                if (index < i)
                    continue;
            } else if (array[count].equals("<")) {
                if (index > i)
                    continue;
            }
            visited[i] = true;
            dfs(count + 1, i, str + i);
        }
        visited[index] = false;
    }
}