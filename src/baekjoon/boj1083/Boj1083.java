package baekjoon.boj1083;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1083 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj1083/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        int S = Integer.parseInt(br.readLine());

        for(int i = 0; i < N && S > 0; i++){
            int max = 0, maxIdx = 0;
            for(int j = i; j < N && j <= S + i; j++){
                if(max <= list.get(j)){
                    max = list.get(j);
                    maxIdx = j;
                }
            }
            list.remove(maxIdx);
            list.add(i, max);
            S -= maxIdx - i;
        }


        StringBuilder sb = new StringBuilder();
        for(int num : list) sb.append(num).append(" ");
        System.out.println(sb);



    }
}
