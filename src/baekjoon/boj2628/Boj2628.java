package baekjoon.boj2628;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj2628 {
    static int r, c, N;
    static ArrayList<Integer> rowList;
    static ArrayList<Integer> columnList;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("./src/baekjoon/boj2628/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        rowList = new ArrayList<>();
        columnList = new ArrayList<>();

        rowList.add(0);
        rowList.add(r);
        columnList.add(0);
        columnList.add(c);

        int hmax = Integer.MIN_VALUE;
        int wmax = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int opt = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (opt == 0) rowList.add(num);
            else columnList.add(num);
        }

        Collections.sort(rowList);
        Collections.sort(columnList);

        int rlen = rowList.size();
        int clen = columnList.size();

        for (int i = 1; i < clen; i++) {
            int height = columnList.get(i) - columnList.get(i - 1);
            hmax = Math.max(hmax, height);
        }
        for (int j = 1; j < rlen; j++) {
            int width = rowList.get(j) - rowList.get(j - 1);
            wmax = Math.max(wmax, width);
        }

        System.out.println(hmax * wmax);
    }
}
