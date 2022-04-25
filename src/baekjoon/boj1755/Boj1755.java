package baekjoon.boj1755;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1755 {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("./input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 시작범위
        int N = Integer.parseInt(st.nextToken()); // 끝 범위

        int size = N - M + 1;	// 범위 크기
        int[] fix = {8, 5, 4, 9, 1, 7, 6, 3, 2, 0};

        ArrayList<Integer> answer = new ArrayList<Integer>();

        int index = 0;
        int pre = 0;
        int tmp = fix[0];
        int plus = 0;
        for(int i = 0; i < 100; i++) {
            if(index == 10) {
                tmp = fix[++pre];
                index = 0;
            }
            if(index == 0) {
                int value = fix[plus++];
                if(value != 0 && value >= M && value <= N)	answer.add(value);
            }
            int tmp2 = fix[index++];

            if(tmp != 0) {
                int num = tmp*10 + tmp2;
                if(num >= M && num <= N)	answer.add(num);
            }
        }
        int count = 0;
        for(int value : answer) {
            if(count % 10 == 0 && count != 0) {
                sb.append("\n");
            }
            sb.append(value).append(" ");
            count++;
        }
        System.out.println(sb.toString());

    }


}
