package baekjoon.boj25757;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj25757 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./src/baekjoon/boj25757/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        String str = st.nextToken();
        int M = 0;
        if (str.equals("Y")) M = 1;
        else if (str.equals("F")) M = 2;
        else M = 3;

        Set<String> names = new HashSet<>();

        for (int i = 0; i < N; i++) {
            names.add(br.readLine());
        }

        int len = names.size();
        System.out.println(len / M);
    }
}
