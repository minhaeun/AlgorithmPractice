package baekjoon.boj22233;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Boj22233 {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("./src/baekjoon/boj22233/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            set.add(br.readLine());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()){
                String str = st.nextToken();
                if(!set.contains(str))  continue;
                set.remove(str);
            }

            sb.append(set.size()).append("\n");
        }

        System.out.println(sb);

    }
}
